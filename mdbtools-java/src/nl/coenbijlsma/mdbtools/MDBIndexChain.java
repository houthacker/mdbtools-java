package nl.coenbijlsma.mdbtools;

public class MDBIndexChain {

    private int currentDepth;
    private int lastLeafFound;
    private int cleanUpMode;
    private MDBIndexPage[] pages;
    
    public MDBIndexChain(){
	pages = new MDBIndexPage[MDBHandle.MDB_MAX_INDEX_DEPTH];
    }
}
