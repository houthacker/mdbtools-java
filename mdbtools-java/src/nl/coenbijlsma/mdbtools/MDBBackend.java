package nl.coenbijlsma.mdbtools;

import java.util.HashSet;

public class MDBBackend {

    private HashSet<MDBBackendType> types;
    
    public MDBBackend(){
	types = new HashSet<MDBBackendType>();
	types.add(new MDBBackendType("Unknown 0x00", false, false, false));
	types.add(new MDBBackendType("Boolean", false, false, false));
	types.add(new MDBBackendType("Byte", false, false, false));
	types.add(new MDBBackendType("Integer", false, false, false));
	types.add(new MDBBackendType("Long Integer", false, false, false));
	types.add(new MDBBackendType("Currency", false, false, false));
	types.add(new MDBBackendType("Single", false, false, false));
	types.add(new MDBBackendType("Double", false, false, false));
	types.add(new MDBBackendType("DateTime (Short)", false, false, true));
	types.add(new MDBBackendType("Unknown 0x09", false, false, false));
	types.add(new MDBBackendType("Text", true, false, true));
	types.add(new MDBBackendType("OLE", true, false, true));
	types.add(new MDBBackendType("Memo/Hyperlink", true, false, true));
	types.add(new MDBBackendType("Unknown 0x0d", false, false, false));
	types.add(new MDBBackendType("Unknown 0x0e", false, false, false));
	types.add(new MDBBackendType("Replication ID", false, false, false));
	types.add(new MDBBackendType("Numberic", true, false, false));
	
    }

    public HashSet<MDBBackendType> getTypes() {
        return types;
    }

    public void setTypes(HashSet<MDBBackendType> types) {
        this.types = types;
    }
    
    public MDBBackendType getTypeByName(String name) {
    	for( MDBBackendType type : types ) {
    		if(type.getName().equalsIgnoreCase(name) ) {
    			return type;
    		}
    	}
    	return null;
    }

}
