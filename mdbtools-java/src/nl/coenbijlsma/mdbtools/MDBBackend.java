package nl.coenbijlsma.mdbtools;

import java.util.ArrayList;

public class MDBBackend {

    private ArrayList<MDBBackendType> types;
    
    public MDBBackend(){
	types = new ArrayList<MDBBackendType>();
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

    public ArrayList<MDBBackendType> getTypes() {
        return types;
    }

    public void setTypes(ArrayList<MDBBackendType> types) {
        this.types = types;
    }
    
    

    
}
