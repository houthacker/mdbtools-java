package nl.coenbijlsma.mdbtools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;

import nl.coenbijlsma.mdbtools.exceptions.IllegalOffsetException;
import nl.coenbijlsma.mdbtools.tools.Tools;

public class MDBFile {

    private File file;
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
    
    private  FileInputStream fis;
    private  FileOutputStream fos;
    
    public MDBFile(String filename) throws IOException {
	this.file = new File(filename);
	handles = new HashSet<MDBHandle>();
    }
    
    public void addHandle(MDBHandle handle){
	handles.add(handle);
    }
    
    public void removeHandle(MDBHandle handle){
	handles.remove(handle);
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
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
    
    public FileInputStream getFileInputStream() {
	return fis;
    }
    
    public FileOutputStream getFileOutputStream() {
	return fos;
    }
    
    /**
     * Opens the MDB file and returns the {@code MDBHandle} 
     */
    public MDBHandle open(EMDBFileFlag flags) throws IOException {
	this.fis = new FileInputStream(file);
	
	if( flags == EMDBFileFlag.MDB_WRITABLE){
	    this.fos = new FileOutputStream(file);
	}
	
	MDBHandle mdb = new MDBHandle(this);
	
	byte[] bytes = readPage(mdb);
	try{
	    int jetVersion = Tools.toInt(bytes, jetVersionOffset);
	    
	    EMDBJetVersion version = EMDBJetVersion.byValue(jetVersion);
	    
	    switch(version){
	    case MDB_JET4:
		mdb.setFormat(MDBFormat.VERSION4);
		return mdb;
	    case MDB_JET3:
		mdb.setFormat(MDBFormat.VERSION3);
		return mdb;
		default:
		    throw new IOException("Invalid Jet version");
	    }
	}catch(IllegalOffsetException ex){
	    throw new IOException("Could not read Jet version", ex);
	}
    }
        
    public void close() throws IOException {
	// Close all the references to this file
	for(MDBHandle handle : handles){
	    handle.close();
	}
	
	if( fis != null ){
	    fis.close();
	    fis = null;
	}
	if( fos != null ){
	    fos.close();
	    fos = null;
	}
	
    }
    
    private byte[] readPage(MDBHandle handle) throws IOException {
	
	byte[] retval = handle.getPageBuffer();
	
	fis.read(retval);
	
	return retval;
    }
    
    public static void main(String[] args) throws Throwable {
	MDBFile mdbFile = new MDBFile("EAReferenceModel.eap");
	mdbFile.open(EMDBFileFlag.MDB_NOFLAGS);
	mdbFile.close();
    }
    
}
