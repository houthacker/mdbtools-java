package nl.coenbijlsma.mdbtools;

public enum EMDBJetVersion {

    MDB_JET3 (0)
    , MDB_JET4 (1)
    , MDB_JETUNKNOWN (-1);
    
    private final int identifier;
    
    EMDBJetVersion(int identifier){
	this.identifier = identifier;
    }
    
    public int getIdentifier(){
	return identifier;
    }
    
    public static EMDBJetVersion byValue(int value){
	switch(value) {
	case 0:
	    return MDB_JET3;
	case 1:
	    return MDB_JET4;
	    
	    default:
		return MDB_JETUNKNOWN; 
	}
    }
}
