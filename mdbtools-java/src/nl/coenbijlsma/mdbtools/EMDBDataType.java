package nl.coenbijlsma.mdbtools;

public enum EMDBDataType {

    BOOL (0x01)
    , BYTE (0x02)
    , INT (0x03)
    , LONGINT (0x04)
    , MONEY (0x05)
    , FLOAT (0x06)
    , DOUBLE (0x07)
    , DATETIME (0x08)
    , TEXT (0x0a)
    , OLE (0x0b)
    , MEMO (0x0c)
    , REPID (0x0f)
    , NUMERIC (0x10);
    
    private final int identifier;
    
    EMDBDataType(int identifier){
	this.identifier = identifier;
    }
    
    public int getIdentifier() {
	return identifier;
    }
}
