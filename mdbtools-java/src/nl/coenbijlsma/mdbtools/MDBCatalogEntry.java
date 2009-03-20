package nl.coenbijlsma.mdbtools;

import java.util.ArrayList;

public class MDBCatalogEntry {

	private static String[] typeNames;
	
    private MDBHandle handle;
    private String objectName;
    private int objectType;
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

    public int getObjectType() {
        return objectType;
    }

    public void setObjectType(int objectType) {
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
}
