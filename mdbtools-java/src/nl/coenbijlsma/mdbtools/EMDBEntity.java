package nl.coenbijlsma.mdbtools;

public enum EMDBEntity {

    MDBForm (0)
    , MDBTable (1)
    , MDBMacro (2)
    , MDBSystemTable (3)
    , MDBReport (4)
    , MDBQuery (5)
    , MDBLinkedTable (6)
    , MDBModule (7)
    , MDBRelationship (8)
    , MDBUnknown09 (9)
    , MDBUnknown0A (10)
    , MDBAny (-1);
    
    private final int identity;
    
    EMDBEntity(int identifier) {
    	this.identity = identifier;
    }
    
    public int getIdentity() {
    	return identity;
    }
}
