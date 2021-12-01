package edu.najah.it.capp.asd.intf;


import edu.najah.it.capp.asd.service.Connection;
import edu.najah.it.capp.exception.ConnectionIsAlreadyReleased;
import edu.najah.it.capp.exception.NoConnection;
import edu.najah.it.capp.exception.ProtocolException;
import edu.najah.it.capp.exception.SystemBusy;
import edu.najah.it.capp.exception.UnableToReleaseTheConnection;
import edu.najah.it.capp.exception.connectionIsUse;
import edu.najah.it.capp.exception.timeoutConnection;

public interface Protocol {
	Connection con = null;
	public static final Protocol timeout = null;
	public static final Protocol busy = null;
	public static final Protocol used = null;

	public default boolean release() throws Exception{
		//Connection is already released
		if(con.release(null) == false) {
			throw new ConnectionIsAlreadyReleased("Connection is already released");
		}
		
		//connection is use 
		if(con == used) {
			throw new connectionIsUse("connection is use ");
		}
				
		//Unable to release the connection 
		if(!con.release(null))
			return true;
		else {
			throw new UnableToReleaseTheConnection("Unable to release the connection ");
		}
		}
	
	
	public default void send(String message) throws ProtocolException{
		//No connection
		if(con == null) {
			throw new NoConnection("No connection");
		}
		//timeout connection
		if(con == timeout) {
			throw new timeoutConnection("timeout connection");
		}
		//System busy
		if(con == busy) {
			throw new SystemBusy("System busy");
		}
		
		throw new ProtocolException("unknown exception");
	}


	

}
