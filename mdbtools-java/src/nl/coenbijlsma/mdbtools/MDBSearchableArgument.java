package nl.coenbijlsma.mdbtools;

public class MDBSearchableArgument {

    private int op;
    private MDBAny value;
    
    public MDBSearchableArgument(){}

    public int getOp() {
        return op;
    }

    public void setOp(int op) {
        this.op = op;
    }

    public MDBAny getValue() {
        return value;
    }

    public void setValue(MDBAny value) {
        this.value = value;
    }
    
    
}
