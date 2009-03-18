package nl.coenbijlsma.mdbtools;

public enum EMDBPage {

    MDB_PAGE_DB (0)
    , MDB_PAGE_DATA (1)
    , MDB_PAGE_TABLE (2)
    , MDB_PAGE_INDEX (3)
    , MDB_PAGE_LEAF (4)
    , MDB_PAGE_MAP (5);
    
    private final int identifier;
    
    EMDBPage(int identifier){
	this.identifier = identifier;
    }
    
    public int getIdentifier() {
	return identifier;
    }
}
