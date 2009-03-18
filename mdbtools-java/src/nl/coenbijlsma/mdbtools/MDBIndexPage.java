package nl.coenbijlsma.mdbtools;

public class MDBIndexPage {

    private long pg;
    private int startPosition;
    private int offset;
    private int length;
    private int[] indexStarts;
    private String cacheValue;
    
    public MDBIndexPage(){
	indexStarts = new int[2000];
    }

    public long getPg() {
        return pg;
    }

    public void setPg(long pg) {
        this.pg = pg;
    }

    public int getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(int startPosition) {
        this.startPosition = startPosition;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int[] getIndexStarts() {
        return indexStarts;
    }

    public void setIndexStarts(int[] indexStarts) {
        this.indexStarts = indexStarts;
    }

    public String getCacheValue() {
        return cacheValue;
    }

    public void setCacheValue(String cacheValue) {
        this.cacheValue = cacheValue;
    }
    
    
}
