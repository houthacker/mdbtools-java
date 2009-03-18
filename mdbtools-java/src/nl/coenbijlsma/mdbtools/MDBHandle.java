package nl.coenbijlsma.mdbtools;

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
    private int currentPage;
    private int rowNumber;
    private long currentPosition;
    private byte[] pageBuffer;
    private byte[] alternatePageBuffer;
    private long catalogNumber;
    private ArrayList<Integer> catalog;
    private MDBBackend defaultBackend;
    private String backendName;
    private MDBFormat format;
    private MDBStatistics stats;
    
    public MDBHandle(MDBFile file){
	pageBuffer = new byte[MDB_PGSIZE];
	alternatePageBuffer = new byte[MDB_PGSIZE];
	catalog = new ArrayList<Integer>();
	mdbFile = file;
	mdbFile.addHandle(this);
    }
    
    public MDBHandle clone(){
	MDBHandle clone = new MDBHandle(mdbFile);
		
	return clone;
    }
    
    public void close() {
	mdbFile.removeHandle(this);
	// TODO flush buffers or something?
    }

    public MDBFile getMdbFile() {
        return mdbFile;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
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

    public byte[] getAlternatePageBuffer() {
        return alternatePageBuffer;
    }

    public void setAlternatePageBuffer(byte[] alternatePageBuffer) {
        this.alternatePageBuffer = alternatePageBuffer;
    }

    public long getCatalogNumber() {
        return catalogNumber;
    }

    public void setCatalogNumber(long catalogNumber) {
        this.catalogNumber = catalogNumber;
    }

    public ArrayList<Integer> getCatalog() {
        return catalog;
    }

    public void setCatalog(ArrayList<Integer> catalog) {
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
    
    
}
