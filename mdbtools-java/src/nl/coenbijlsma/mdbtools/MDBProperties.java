package nl.coenbijlsma.mdbtools;

import java.util.Hashtable;

public class MDBProperties {

    private String name;
    private Hashtable hash;
    
    public MDBProperties(){
	
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hashtable getHash() {
        return hash;
    }

    public void setHash(Hashtable hash) {
        this.hash = hash;
    }
    
    
    
}
