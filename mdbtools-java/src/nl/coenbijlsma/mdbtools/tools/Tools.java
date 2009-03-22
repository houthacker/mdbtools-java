package nl.coenbijlsma.mdbtools.tools;

import nl.coenbijlsma.mdbtools.exceptions.IllegalOffsetException;

public class Tools {

    public static final int toInt(byte[] b, int offset) throws IllegalOffsetException {
	if( (b.length - offset) < 4 || offset < 0){
	    throw new IllegalOffsetException("Cannot read an int from this offset (" + offset + ")");
	}
	
	
	int low = b[offset] & 0xff;
	int high = b[offset + 1] & 0xff;
	return (int) ( high << 4 | low );
    }
}
