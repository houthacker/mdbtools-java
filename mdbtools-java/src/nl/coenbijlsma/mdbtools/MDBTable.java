package nl.coenbijlsma.mdbtools;

import java.util.ArrayList;

public class MDBTable {

    private MDBCatalogEntry entry;
    private String name;
    private long numberOfCOlumns;
    private ArrayList<MDBColumn> columns;
    private long numberOfRows;
    private int indexStart;
    private long numberOfRealIndexes;
    private long numberOfIndexes;
    private ArrayList<Object> indexes;
    private int firstDataPage;
    private int currentPageNumber;
    private int currentPhysicalPage;
    private long currentRow;
    boolean noSkipDeletedRows;
    private int mapBasePage;
    private long map_sz; // ???
    private String usage_map; // ???
    private int freemapBasePages; // pages with free space left
    private MDBSearchableArgumentTree searchableArgsTree;
    private EMDBStrategy strategy;
    private MDBIndex scanIndex;
    private MDBHandle mdbIndex;
    private MDBIndexChain chain;
    private MDBProperties properties;
    private long numberOfVariableColumns;
    private boolean isTempTable;
    private ArrayList<Object> tempTablePages;
    
    public MDBTable(){
		columns = new ArrayList<MDBColumn>();
		indexes = new ArrayList<Object>();
		tempTablePages = new ArrayList<Object>();
    }

    public MDBCatalogEntry getEntry() {
        return entry;
    }

    public void setEntry(MDBCatalogEntry entry) {
        this.entry = entry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getNumberOfCOlumns() {
        return numberOfCOlumns;
    }

    public void setNumberOfCOlumns(long numberOfCOlumns) {
        this.numberOfCOlumns = numberOfCOlumns;
    }

    public ArrayList<MDBColumn> getColumns() {
        return columns;
    }

    public void setColumns(ArrayList<MDBColumn> columns) {
        this.columns = columns;
    }

    public long getNumberOfRows() {
        return numberOfRows;
    }

    public void setNumberOfRows(long numberOfRows) {
        this.numberOfRows = numberOfRows;
    }

    public int getIndexStart() {
        return indexStart;
    }

    public void setIndexStart(int indexStart) {
        this.indexStart = indexStart;
    }

    public long getNumberOfRealIndexes() {
        return numberOfRealIndexes;
    }

    public void setNumberOfRealIndexes(long numberOfRealIndexes) {
        this.numberOfRealIndexes = numberOfRealIndexes;
    }

    public long getNumberOfIndexes() {
        return numberOfIndexes;
    }

    public void setNumberOfIndexes(long numberOfIndexes) {
        this.numberOfIndexes = numberOfIndexes;
    }

    public ArrayList<Object> getIndexes() {
        return indexes;
    }

    public void setIndexes(ArrayList<Object> indexes) {
        this.indexes = indexes;
    }

    public int getFirstDataPage() {
        return firstDataPage;
    }

    public void setFirstDataPage(int firstDataPage) {
        this.firstDataPage = firstDataPage;
    }

    public int getCurrentPageNumber() {
        return currentPageNumber;
    }

    public void setCurrentPageNumber(int currentPageNumber) {
        this.currentPageNumber = currentPageNumber;
    }

    public int getCurrentPhysicalPage() {
        return currentPhysicalPage;
    }

    public void setCurrentPhysicalPage(int currentPhysicalPage) {
        this.currentPhysicalPage = currentPhysicalPage;
    }

    public long getCurrentRow() {
        return currentRow;
    }

    public void setCurrentRow(long currentRow) {
        this.currentRow = currentRow;
    }

    public boolean isNoSkipDeletedRows() {
        return noSkipDeletedRows;
    }

    public void setNoSkipDeletedRows(boolean noSkipDeletedRows) {
        this.noSkipDeletedRows = noSkipDeletedRows;
    }

    public int getMapBasePage() {
        return mapBasePage;
    }

    public void setMapBasePage(int mapBasePage) {
        this.mapBasePage = mapBasePage;
    }

    public long getMap_sz() {
        return map_sz;
    }

    public void setMap_sz(long map_sz) {
        this.map_sz = map_sz;
    }

    public String getUsage_map() {
        return usage_map;
    }

    public void setUsage_map(String usage_map) {
        this.usage_map = usage_map;
    }

    public int getFreemapBasePages() {
        return freemapBasePages;
    }

    public void setFreemapBasePages(int freemapBasePages) {
        this.freemapBasePages = freemapBasePages;
    }

    public MDBSearchableArgumentTree getSearchableArgsTree() {
        return searchableArgsTree;
    }

    public void setSearchableArgsTree(MDBSearchableArgumentTree searchableArgsTree) {
        this.searchableArgsTree = searchableArgsTree;
    }

    public EMDBStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(EMDBStrategy strategy) {
        this.strategy = strategy;
    }

    public MDBIndex getScanIndex() {
        return scanIndex;
    }

    public void setScanIndex(MDBIndex scanIndex) {
        this.scanIndex = scanIndex;
    }

    public MDBHandle getMdbIndex() {
        return mdbIndex;
    }

    public void setMdbIndex(MDBHandle mdbIndex) {
        this.mdbIndex = mdbIndex;
    }

    public MDBIndexChain getChain() {
        return chain;
    }

    public void setChain(MDBIndexChain chain) {
        this.chain = chain;
    }

    public MDBProperties getProperties() {
        return properties;
    }

    public void setProperties(MDBProperties properties) {
        this.properties = properties;
    }

    public long getNumberOfVariableColumns() {
        return numberOfVariableColumns;
    }

    public void setNumberOfVariableColumns(long numberOfVariableColumns) {
        this.numberOfVariableColumns = numberOfVariableColumns;
    }

    public boolean isTempTable() {
        return isTempTable;
    }

    public void setTempTable(boolean isTempTable) {
        this.isTempTable = isTempTable;
    }

    public ArrayList<Object> getTempTablePages() {
        return tempTablePages;
    }

    public void setTempTablePages(ArrayList<Object> tempTablePages) {
        this.tempTablePages = tempTablePages;
    }
    
    public ArrayList<MDBColumn> readColumns() {
    	if( columns.size() > 0 ){
    		return columns;
    	}
    	// TODO
    	return columns;
    }
    
    
}
