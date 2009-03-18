package nl.coenbijlsma.mdbtools;

public class MDBIndex {

    private int indexNumber;
    private String name;
    private String indexType;
    private long firstPage;
    private int numberOfRows;
    private long numberOfKeys;
    private int[] keyColNumbers;
    private int[] keyColumnOrder;
    private int flags;
    private MDBTable table;
    
    public MDBIndex(){
	keyColNumbers = new int[MDBHandle.MDB_MAX_INDEX_COLS];
	keyColumnOrder = new int[MDBHandle.MDB_MAX_INDEX_COLS];
    }

    public int getIndexNumber() {
        return indexNumber;
    }

    public void setIndexNumber(int indexNumber) {
        this.indexNumber = indexNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIndexType() {
        return indexType;
    }

    public void setIndexType(String indexType) {
        this.indexType = indexType;
    }

    public long getFirstPage() {
        return firstPage;
    }

    public void setFirstPage(long firstPage) {
        this.firstPage = firstPage;
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public void setNumberOfRows(int numberOfRows) {
        this.numberOfRows = numberOfRows;
    }

    public long getNumberOfKeys() {
        return numberOfKeys;
    }

    public void setNumberOfKeys(long numberOfKeys) {
        this.numberOfKeys = numberOfKeys;
    }

    public int[] getKeyColNumbers() {
        return keyColNumbers;
    }

    public void setKeyColNumbers(int[] keyColNumbers) {
        this.keyColNumbers = keyColNumbers;
    }

    public int[] getKeyColumnOrder() {
        return keyColumnOrder;
    }

    public void setKeyColumnOrder(int[] keyColumnOrder) {
        this.keyColumnOrder = keyColumnOrder;
    }

    public int getFlags() {
        return flags;
    }

    public void setFlags(int flags) {
        this.flags = flags;
    }

    public MDBTable getTable() {
        return table;
    }

    public void setTable(MDBTable table) {
        this.table = table;
    }
    
    
}
