package nl.coenbijlsma.mdbtools;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

import nl.coenbijlsma.mdbtools.exceptions.IllegalOffsetException;
import nl.coenbijlsma.mdbtools.tools.Tools;

public class MDBCatalogEntry {

	private static String[] typeNames;
	
    private MDBHandle handle;
    private String objectName;
    private EMDBEntity objectType;
    private long page;
    private long kkdPage;
    private long kkdRowID;
    private int numberOfProperties;
    private ArrayList<Object> properties;
    private ArrayList<Object> columns;
    private int flags;
    
    static {
    	typeNames = new String[] {"Form"
    			, "Table"
    			, "Macro"
    			, "System Table"
    			, "Report"
    			, "Query"
    			, "Linked Table"
    			, "Module"
    			, "Relationship"
    			, "Unknown 0x09"
    			, "Unknown 0x0a"
    			, "Database"};
    	
    }
    
    public MDBCatalogEntry(){
		properties = new ArrayList<Object>();
		columns = new ArrayList<Object>();
    }

    public MDBHandle getHandle() {
        return handle;
    }

    public void setHandle(MDBHandle handle) {
        this.handle = handle;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public EMDBEntity getObjectType() {
        return objectType;
    }

    public void setObjectType(EMDBEntity objectType) {
        this.objectType = objectType;
    }

    public long getPage() {
        return page;
    }

    public void setPage(long page) {
        this.page = page;
    }

    public long getKkdPage() {
        return kkdPage;
    }

    public void setKkdPage(long kkdPage) {
        this.kkdPage = kkdPage;
    }

    public long getKkdRowID() {
        return kkdRowID;
    }

    public void setKkdRowID(long kkdRowID) {
        this.kkdRowID = kkdRowID;
    }

    public int getNumberOfProperties() {
        return numberOfProperties;
    }

    public void setNumberOfProperties(int numberOfProperties) {
        this.numberOfProperties = numberOfProperties;
    }

    public ArrayList<Object> getProperties() {
        return properties;
    }

    public void setProperties(ArrayList<Object> properties) {
        this.properties = properties;
    }

    public ArrayList<Object> getColumns() {
        return columns;
    }

    public void setColumns(ArrayList<Object> columns) {
        this.columns = columns;
    }

    public int getFlags() {
        return flags;
    }

    public void setFlags(int flags) {
        this.flags = flags;
    }
    
    public String getTypeName(int type) {
    	if( type < 0 || type > 11 ) {
    		return null;
    	}
    	return typeNames[type];
    }
    
    public MDBTable readTable() throws IOException {
    	MDBTable table;
    	MDBHandle handle = this.handle;    	
    	MDBFormat format = handle.getFormat();
    	RandomAccessFile file = handle.getMdbFile().getFile();
    	int rowStart, pageRow;
    	short len;
    	Object buf; // ???
    	byte[] pageBuffer;
    	
    	pageBuffer =handle.readPage((int)page, false);
    	//pageBuffer = handle.getPageBuffer();
    	file.seek(page * MDBHandle.MDB_PGSIZE);
    	byte b = file.readByte();
    	
    	if( b != 2){
    		// Invalid table definition
    		System.out.println("Invalid table definition: " + b);
    		return null;
    	}
    	
    	table = getTable();
    	file.seek(page * MDBHandle.MDB_PGSIZE + 8);
    	len = file.readShort();
    	
    	System.out.println("len == " + len);
    	
    	//file.seek(page * MDBHandle.MDB_PGSIZE);
    	//int rows = file.readInt();
    	//try{
    		//file.seek( (page * MDBHandle.MDB_PGSIZE) + handle.getFormat().getTableNumberOfRowsOffset());
    		//System.out.println(file.getFilePointer());
    		
    		file.seek(page * MDBHandle.MDB_PGSIZE + 12);
    		int rows = file.readInt();
    		System.out.println(" rows == " + rows);
    		
    		//int rows = pageBuffer[12];
    		//rows <<= 8;
    		//rows |= pageBuffer[13];
//    		short rows = file.readShort();
    		
//    		System.out.println(" rows == " + rows);
    		
	    	table.setNumberOfRows(rows);
//    	}catch(IllegalOffsetException ex) {
//    		ex.printStackTrace();
//    	}
    	// TODO
    	return table;
    }
    
    private MDBTable getTable(){
    	MDBTable table = new MDBTable();
    	table.setEntry(this);
    	table.setName(objectName);
    	
    	return table;
    }
}
