package nl.coenbijlsma.mdbtools;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashSet;

public class MDBFile {

	private String filename;
    private RandomAccessFile file;
    private EMDBJetVersion jetVersion;
    private int databaseKey;
    private char[] databasePassword;
    private MDBBackend defaultBackend;
    private String backendName;
    private MDBStatistics stats;
    private int map_sz; // no idea what this means (comes from mdbtools/mdbtools:191
    private String free_map; // idem
    //private int referenceCount;
    
    private HashSet<MDBHandle> handles;
    
    private static final int jetVersionOffset = 0x14;
    
    public MDBFile(String filename) throws IOException {
    	if( filename == null || filename.trim().length() == 0 ) {
    		throw new IOException("Empty filename not allowed");
    	}
    	
		handles = new HashSet<MDBHandle>();
		this.filename = filename;
		this.stats = new MDBStatistics();
    }
    
    public void addHandle(MDBHandle handle){
    	handles.add(handle);
    }
    
    public void removeHandle(MDBHandle handle){
    	handles.remove(handle);
    }

    public RandomAccessFile getFile() {
        return file;
    }

    public void setFile(RandomAccessFile file) {
        this.file = file;
    }

    public EMDBJetVersion getJetVersion() {
        return jetVersion;
    }

    public void setJetVersion(EMDBJetVersion jetVersion) {
        this.jetVersion = jetVersion;
    }

    public int getDatabaseKey() {
        return databaseKey;
    }

    public void setDatabaseKey(int databaseKey) {
        this.databaseKey = databaseKey;
    }

    public char[] getDatabasePassword() {
        return databasePassword;
    }

    public void setDatabasePassword(char[] databasePassword) {
        this.databasePassword = databasePassword;
    }

    public MDBBackend getDefaultBackend() {
        return defaultBackend;
    }

    public void setDefaultBackend(MDBBackend defaultBackend) {
        this.defaultBackend = defaultBackend;
    }

    public String getBackendName() {
        return backendName;
    }

    public void setBackendName(String backendName) {
        this.backendName = backendName;
    }

    public MDBStatistics getStats() {
        return stats;
    }

    public void setStats(MDBStatistics stats) {
        this.stats = stats;
    }

    public int getMap_sz() {
        return map_sz;
    }

    public void setMap_sz(int map_sz) {
        this.map_sz = map_sz;
    }

    public String getFree_map() {
        return free_map;
    }

    public void setFree_map(String free_map) {
        this.free_map = free_map;
    }

    public int getReferenceCount() {
        return handles.size();
    }
    
    ///////////////////////////////////////////////////////////////////////////
    //			END OF GETTERS AND SETTERS                           //
    ///////////////////////////////////////////////////////////////////////////
    
    /**
     * Opens the MDB file and returns the {@code MDBHandle} 
     */
    public MDBHandle open(EMDBFileFlag flags) throws IOException {
		if( flags == EMDBFileFlag.MDB_WRITABLE){
		    this.file = new RandomAccessFile(filename, "rws");
		}else {
			this.file = new RandomAccessFile(filename, "r");
		}
		
		MDBHandle mdb = new MDBHandle(this);

		file.seek((long)jetVersionOffset);
	    int jetVersion = file.readInt();
	    
	    EMDBJetVersion version = EMDBJetVersion.byValue(jetVersion);
	    
	    switch(version){
	    case MDB_JET4:
	    	mdb.setFormat(MDBFormat.VERSION4);
	    	return mdb;
	    case MDB_JET3:
	    	mdb.setFormat(MDBFormat.VERSION3);
	    	return mdb;
		default:
		    throw new IOException("Invalid Jet version: " + jetVersion);
	    }
	    	    
    }
        
    public void close() throws IOException {
    	if( file == null ) {
    		throw new IOException("File not open");
    	}
    	
		// Close all the references to this file
		handles.clear();
		
		file.close();
		file = null;
    }
    
    public static void main(String[] args) throws Throwable {
		MDBFile mdbFile = new MDBFile("EAReferenceModel.eap");
		MDBHandle handle = mdbFile.open(EMDBFileFlag.MDB_WRITABLE);
		handle.getTableByName("t_object", EMDBEntity.MDBTable);
		mdbFile.close();
    }
    
}
