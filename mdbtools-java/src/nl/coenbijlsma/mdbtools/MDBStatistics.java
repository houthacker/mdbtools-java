package nl.coenbijlsma.mdbtools;

public class MDBStatistics {

    private boolean collect;
    private long pageReads;
    
    public MDBStatistics() {
	collect = false;
	pageReads = 0L;
    }

    public boolean isCollect() {
        return collect;
    }

    public void setCollect(boolean collect) {
        this.collect = collect;
    }

    public long getPageReads() {
        return pageReads;
    }

    public void setPageReads(long pageReads) {
        this.pageReads = pageReads;
    }
    
    
}
