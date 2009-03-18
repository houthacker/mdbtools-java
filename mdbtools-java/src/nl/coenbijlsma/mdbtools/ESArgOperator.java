package nl.coenbijlsma.mdbtools;

public enum ESArgOperator {

    MDB_OR (1)
    , MDB_AND (2)
    , MDB_NOT (3)
    , MDB_EQUAL (4)
    , MDB_GT (5)
    , MDB_LT (6)
    , MDB_GTEQ (7)
    , MDB_LTEQ (8)
    , MDB_LIKE (9)
    , MDB_ISNULL (10)
    , MDB_NOTNULL (11);

    private final int identifier;
    
    ESArgOperator(int identifier){
	this.identifier = identifier;
    }
    
    public int getIdentifier() {
	return identifier;
    }
}
