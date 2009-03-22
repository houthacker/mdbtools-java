package nl.coenbijlsma.mdbtools;

import java.io.IOException;
import java.util.ArrayList;

public class MDBHandle {

    public static final int MDB_PGSIZE = 4096;
    public static final int MDB_MAX_OBJECT_NAME = 256;
    public static final int MDB_MAX_COLS = 256;
    public static final int MDB_MAX_INDEX_COLS = 10;
    public static final int MDB_CATALOG_PG = 18;
    public static final int MDB_MEMO_OVERHEAD = 12;
    public static final int MDB_BIND_SIZE = 16384;
    public static final int MDB_MAX_INDEX_DEPTH = 10;
    
    private MDBFile mdbFile;
    private long currentPage;
    private int rowNumber;
    private long currentPosition;
    private byte[] pageBuffer;
    private byte[] alternatePageBuffer;
    //private long catalogNumber;
    private ArrayList<MDBCatalogEntry> catalog;
    private MDBBackend defaultBackend;
    private String backendName;
    private MDBFormat format;
    private MDBStatistics stats;
    
    public MDBHandle(MDBFile file){
		pageBuffer = new byte[MDB_PGSIZE];
		alternatePageBuffer = new byte[MDB_PGSIZE];
		catalog = new ArrayList<MDBCatalogEntry>();
		mdbFile = file;
		mdbFile.addHandle(this);
		stats = new MDBStatistics(true);
    }
	    
    public MDBHandle clone(){
		MDBHandle clone = new MDBHandle(mdbFile);
			
		return clone;
    }
    
    public void close() {
		mdbFile.removeHandle(this);
		// TODO flush buffers or something?
    }
    
    public byte[] readPage(int page, boolean alternate) throws IOException {
    	System.out.println("MDBHandle::readPage(" + page + ", " + alternate + ")");
    	// Throw an IOException if the page is before the BOF
    	if( page < 0 ){
    		throw new IOException("Page " + page + " is before BOF");
    	}
    	
    	long offset = page * MDBHandle.MDB_PGSIZE;
    	
    	// Throw an IOException if the offset is beyond the EOF
    	if( mdbFile.getFile().length() < offset ){
    		throw new IOException("Page " + page + " is beyond EOF");
    	}
    	
    	byte[] retval = null;
    	if( alternate ) {
    		retval = clearAlternateBuffer();
    	} else {
    		retval = clearBuffer();
    	}
		
		mdbFile.getFile().seek(offset);
		mdbFile.getFile().read(retval);
		
		// Update the statistics
		MDBStatistics stats = mdbFile.getStats();
		if( stats.mustCollect() ) {
			stats.incrementPageReads();
		}
		
		return retval;
    }

    public MDBFile getMdbFile() {
        return mdbFile;
    }

    public long getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(long currentPage) {
        this.currentPage = currentPage;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public long getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(long currentPosition) {
        this.currentPosition = currentPosition;
    }

    public byte[] getPageBuffer() {
        return pageBuffer;
    }

    public void setPageBuffer(byte[] pageBuffer) {
        this.pageBuffer = pageBuffer;
    }
    
    public byte[] clearBuffer() {
    	pageBuffer = null;
    	pageBuffer = new byte[MDB_PGSIZE];
    	return pageBuffer;
    }

    public byte[] getAlternatePageBuffer() {
        return alternatePageBuffer;
    }

    public void setAlternatePageBuffer(byte[] alternatePageBuffer) {
        this.alternatePageBuffer = alternatePageBuffer;
    }
    
    public byte[] clearAlternateBuffer() {
    	alternatePageBuffer = null;
    	alternatePageBuffer = new byte[MDB_PGSIZE];
    	return alternatePageBuffer;
    }
    
    public void swapBuffer() {
    	if( pageBuffer == null || alternatePageBuffer == null ) {
    		return;
    	}
    	
    	byte[] temp = new byte[MDB_PGSIZE];
    	
    	// Copy the page buffer into the temp buffer
    	for( int i = 0; i < MDB_PGSIZE; i++ ) {
    		temp[i] = pageBuffer[i];
    	}
    	
    	// Copy the alternate buffer into the page buffer
    	for( int i = 0; i < MDB_PGSIZE; i++ ) {
    		pageBuffer[i] = alternatePageBuffer[i];
    	}
    	
    	// Copy the temp buffer into the alternate buffer
    	for( int i = 0; i < MDB_PGSIZE; i++ ) {
    		alternatePageBuffer[i] = temp[i];
    	}
    	
    }

    /*
    public long getCatalogNumber() {
        return catalogNumber;
    }

    public void setCatalogNumber(long catalogNumber) {
        this.catalogNumber = catalogNumber;
    }
    */

    public ArrayList<MDBCatalogEntry> getCatalog() {
        return catalog;
    }

    public void setCatalog(ArrayList<MDBCatalogEntry> catalog) {
        this.catalog = catalog;
    }

    public MDBBackend getDefaultBackend() {
        return defaultBackend;
    }

    public void setDefaultBackend(MDBBackend defaultBackend) {
        this.defaultBackend = defaultBackend;
    }

    public String getBackendName() {
        return backendName;
    }

    public void setBackendName(String backendName) {
        this.backendName = backendName;
    }

    public MDBFormat getFormat() {
        return format;
    }

    public void setFormat(MDBFormat format) {
        this.format = format;
    }

    public MDBStatistics getStats() {
        return stats;
    }

    public void setStats(MDBStatistics stats) {
        this.stats = stats;
    }
    
    public MDBTable getTableByName(String name, EMDBEntity entityType) throws IOException {
    	// TODO
    	MDBCatalogEntry entry;
    	
    	readCatalog(entityType);
    	
    	for(int i = 0; i < catalog.size(); i++) {
    		entry = catalog.get(i);
    	}
    	
    	// TODO mdb_read_catalog
    	return null;
    }
    
    public void dumpStats() {
    	System.out.println("Physical Page Reads: " + stats.getPageReads());
    }
    
    private void readCatalog(EMDBEntity entityType) throws IOException {
    	MDBCatalogEntry entry = null, mysysobject = null;
    	MDBTable table = null;
    	String objectID;
    	String objectName;
    	String objectType;
    	String objectFlags;
    	int type = 0;
    	
    	if( catalog.size() > 0) {
    		catalog = new ArrayList<MDBCatalogEntry>();
    	}
    	
    	mysysobject = new MDBCatalogEntry();
    	mysysobject.setHandle(this);
    	mysysobject.setObjectType(EMDBEntity.MDBTable);
    	mysysobject.setPage(2);
    	mysysobject.setObjectName("MSysObjects");
    	
    	table = mysysobject.readTable();
    	
    	if( table == null ) {
    		return;
    	}
    	
    	table.readColumns();
    	
    }
}
