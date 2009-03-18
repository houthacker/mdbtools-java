package nl.coenbijlsma.mdbtools;

public enum EMDBIndexConstraint {

    INDEX_UNIQUE (0x01)
    , INDEX_IGNORENULLS (0x02)
    , INDEX_REQUIRED (0x08);
    
    private final int identifier;
    
    private EMDBIndexConstraint(int identifier) {
	this.identifier = identifier;
    }
    
    public int getIdentifier() {
	return identifier;
    }
}
