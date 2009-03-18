package nl.coenbijlsma.mdbtools;

public enum EMDBFileFlag {

    MDB_NOFLAGS (0x00)
    , MDB_WRITABLE (0x01);
    
    private final int flag;
    
    EMDBFileFlag(int flag) {
	this.flag = flag;
    }
    
    public int getFlag() {
	return flag;
    }
}
