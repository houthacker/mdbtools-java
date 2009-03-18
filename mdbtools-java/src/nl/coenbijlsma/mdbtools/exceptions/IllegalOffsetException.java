/**
 * 
 */
package nl.coenbijlsma.mdbtools.exceptions;

/**
 * @author coen
 *
 */
public class IllegalOffsetException extends Exception {

    /**
     * 
     */
    public IllegalOffsetException() {
    }

    /**
     * @param arg0
     */
    public IllegalOffsetException(String arg0) {
	super(arg0);
    }

    /**
     * @param arg0
     */
    public IllegalOffsetException(Throwable arg0) {
	super(arg0);
    }

    /**
     * @param arg0
     * @param arg1
     */
    public IllegalOffsetException(String arg0, Throwable arg1) {
	super(arg0, arg1);
    }

}
