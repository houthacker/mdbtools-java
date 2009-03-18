package nl.coenbijlsma.mdbtools;

public class MDBSearchableArgumentTree {

    private int op;
    private MDBColumn column;
    private MDBAny value;
    private Object parent;
    private MDBSearchableArgumentTree left;
    private MDBSearchableArgumentTree right;
    
    public MDBSearchableArgumentTree(){}

    public int getOp() {
        return op;
    }

    public void setOp(int op) {
        this.op = op;
    }

    public MDBColumn getColumn() {
        return column;
    }

    public void setColumn(MDBColumn column) {
        this.column = column;
    }

    public MDBAny getValue() {
        return value;
    }

    public void setValue(MDBAny value) {
        this.value = value;
    }

    public Object getParent() {
        return parent;
    }

    public void setParent(Object parent) {
        this.parent = parent;
    }

    public MDBSearchableArgumentTree getLeft() {
        return left;
    }

    public void setLeft(MDBSearchableArgumentTree left) {
        this.left = left;
    }

    public MDBSearchableArgumentTree getRight() {
        return right;
    }

    public void setRight(MDBSearchableArgumentTree right) {
        this.right = right;
    }
    
    
}
