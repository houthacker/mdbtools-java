package nl.coenbijlsma.mdbtools;

import java.util.ArrayList;
import java.util.Hashtable;

public class MDBColumn {

    private String name;
    private int columnType;
    private int colunmSize;
    private Object bindObject;
    private int lengthObject;
    private Hashtable properties;
    private long numberOfSearchableArgs;
    private ArrayList<Object> searchableArgs;
    private ArrayList<Object> indexSearchableArgsCache;
    private boolean isFixed;
    private EMDBSort queryOrder;
    private int columnNumber;
    private int currentValueStart;
    private int currentValueLength;
    private long currentBLOBPageRow;
    private int chunkSize;
    private int columnPrec; // no idea what that is
    private int columnScale;
    private MDBProperties props;
    private int fixedOffset;
    private long varColumnNumber;
    private int rowColumnNumber;
    
    public MDBColumn(){
	searchableArgs = new ArrayList<Object>();
	indexSearchableArgsCache = new ArrayList<Object>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getColumnType() {
        return columnType;
    }

    public void setColumnType(int columnType) {
        this.columnType = columnType;
    }

    public int getColunmSize() {
        return colunmSize;
    }

    public void setColunmSize(int colunmSize) {
        this.colunmSize = colunmSize;
    }

    public Object getBindObject() {
        return bindObject;
    }

    public void setBindObject(Object bindObject) {
        this.bindObject = bindObject;
    }

    public int getLengthObject() {
        return lengthObject;
    }

    public void setLengthObject(int lengthObject) {
        this.lengthObject = lengthObject;
    }

    public Hashtable getProperties() {
        return properties;
    }

    public void setProperties(Hashtable properties) {
        this.properties = properties;
    }

    public long getNumberOfSearchableArgs() {
        return numberOfSearchableArgs;
    }

    public void setNumberOfSearchableArgs(long numberOfSearchableArgs) {
        this.numberOfSearchableArgs = numberOfSearchableArgs;
    }

    public ArrayList<Object> getSearchableArgs() {
        return searchableArgs;
    }

    public void setSearchableArgs(ArrayList<Object> searchableArgs) {
        this.searchableArgs = searchableArgs;
    }

    public ArrayList<Object> getIndexSearchableArgsCache() {
        return indexSearchableArgsCache;
    }

    public void setIndexSearchableArgsCache(
    	ArrayList<Object> indexSearchableArgsCache) {
        this.indexSearchableArgsCache = indexSearchableArgsCache;
    }

    public boolean isFixed() {
        return isFixed;
    }

    public void setFixed(boolean isFixed) {
        this.isFixed = isFixed;
    }

    public EMDBSort getQueryOrder() {
        return queryOrder;
    }

    public void setQueryOrder(EMDBSort queryOrder) {
        this.queryOrder = queryOrder;
    }

    public int getColumnNumber() {
        return columnNumber;
    }

    public void setColumnNumber(int columnNumber) {
        this.columnNumber = columnNumber;
    }

    public int getCurrentValueStart() {
        return currentValueStart;
    }

    public void setCurrentValueStart(int currentValueStart) {
        this.currentValueStart = currentValueStart;
    }

    public int getCurrentValueLength() {
        return currentValueLength;
    }

    public void setCurrentValueLength(int currentValueLength) {
        this.currentValueLength = currentValueLength;
    }

    public long getCurrentBLOBPageRow() {
        return currentBLOBPageRow;
    }

    public void setCurrentBLOBPageRow(long currentBLOBPageRow) {
        this.currentBLOBPageRow = currentBLOBPageRow;
    }

    public int getChunkSize() {
        return chunkSize;
    }

    public void setChunkSize(int chunkSize) {
        this.chunkSize = chunkSize;
    }

    public int getColumnPrec() {
        return columnPrec;
    }

    public void setColumnPrec(int columnPrec) {
        this.columnPrec = columnPrec;
    }

    public int getColumnScale() {
        return columnScale;
    }

    public void setColumnScale(int columnScale) {
        this.columnScale = columnScale;
    }

    public MDBProperties getProps() {
        return props;
    }

    public void setProps(MDBProperties props) {
        this.props = props;
    }

    public int getFixedOffset() {
        return fixedOffset;
    }

    public void setFixedOffset(int fixedOffset) {
        this.fixedOffset = fixedOffset;
    }

    public long getVarColumnNumber() {
        return varColumnNumber;
    }

    public void setVarColumnNumber(long varColumnNumber) {
        this.varColumnNumber = varColumnNumber;
    }

    public int getRowColumnNumber() {
        return rowColumnNumber;
    }

    public void setRowColumnNumber(int rowColumnNumber) {
        this.rowColumnNumber = rowColumnNumber;
    }
    
    
}
