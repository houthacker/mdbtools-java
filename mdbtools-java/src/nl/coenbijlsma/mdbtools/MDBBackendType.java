package nl.coenbijlsma.mdbtools;

public class MDBBackendType {

    private String name;
    private boolean needsLength; /*  or precision */
    private boolean needsScale;
    private boolean needsQuotes;
    
    public MDBBackendType(){}
    
    public MDBBackendType(String name, boolean needsLength, boolean needsScale, boolean needsQuotes){
	this();
	setName(name);
	setNeedsLength(needsLength);
	setNeedsScale(needsScale);
	setNeedsQuotes(needsQuotes);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isNeedsLength() {
        return needsLength;
    }

    public void setNeedsLength(boolean needsLength) {
        this.needsLength = needsLength;
    }

    public boolean isNeedsScale() {
        return needsScale;
    }

    public void setNeedsScale(boolean needsScale) {
        this.needsScale = needsScale;
    }

    public boolean isNeedsQuotes() {
        return needsQuotes;
    }

    public void setNeedsQuotes(boolean needsQuotes) {
        this.needsQuotes = needsQuotes;
    }
    
}
