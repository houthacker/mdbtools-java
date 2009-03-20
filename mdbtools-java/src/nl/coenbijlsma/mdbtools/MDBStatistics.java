package nl.coenbijlsma.mdbtools;

public class MDBStatistics {

    private boolean collect;
    private long pageReads;
    
    public MDBStatistics() {
		this(false);
    }
    
    public MDBStatistics(boolean collect) {
    	pageReads = 0L;
    	this.collect = collect;
    }

    public boolean mustCollect() {
        return collect;
    }

    public void setCollect(boolean collect) {
        this.collect = collect;
    }

    public long getPageReads() {
        return pageReads;
    }
    
    public void incrementPageReads() {
    	pageReads++;
    }

    public void setPageReads(long pageReads) {
        this.pageReads = pageReads;
    }
    
}
