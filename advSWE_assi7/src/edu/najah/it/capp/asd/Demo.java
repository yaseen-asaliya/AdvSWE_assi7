package edu.najah.it.capp.asd;

import edu.najah.it.capp.asd.constants.ConnectionType;
import edu.najah.it.capp.asd.impl.Ftp;
import edu.najah.it.capp.asd.intf.Protocol;
import edu.najah.it.capp.asd.service.Connection;
import edu.najah.it.capp.exception.NoConnection;
import edu.najah.it.capp.exception.ProtocolException;
import edu.najah.it.capp.exception.SystemBusy;
import edu.najah.it.capp.exception.timeoutConnection;
import edu.najah.it.capp.exception.UnableToReleaseTheConnection;
import edu.najah.it.capp.exception.ConnectionIsAlreadyReleased;
import edu.najah.it.capp.exception.connectionIsUse;

import edu.najah.it.capp.logger.Logger;

public class Demo {
	
	static void sendExceptions(Protocol P,String text) throws Exception {
		//assume we have 3 try maximum  
		
				int maxNumberOfTry = 3;
				
				while(maxNumberOfTry > 0) {
					try {
						P.send(text);
						Logger.getInstance().logInfo("This is a info message");
						Logger.getInstance().logDebug("This is a debug message");
						Logger.getInstance().logWarning("This is a warning message");
						Logger.getInstance().logError("This is a error message");
						break;
					}
					catch (NoConnection exp) {
						System.out.println("this is the exception :: " + exp.getMessage());
						exp.printStackTrace();
						break;
					}
					catch (timeoutConnection exp) {
						System.out.println("this is the exception :: " + exp.getMessage());
						exp.printStackTrace();
						break;
					}
					catch (SystemBusy exp) {
						System.out.println("this is the exception :: " + exp.getMessage());
						exp.printStackTrace();
						maxNumberOfTry--;
						try {
							Thread.sleep(3000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					catch (Exception exp) {
						System.out.println("Unexpected Error :: " + exp.getMessage());
					}
					finally {
						// To make sure the connection is always released after it is no longer needed.
						P.release();
						
					}
				}
	}
	
	static void releaseExceptions(String str)throws Exception{
		try {
			Connection.release(str);
			Logger.getInstance().logInfo("This is a info message");
			Logger.getInstance().logDebug("This is a debug message");
			Logger.getInstance().logWarning("This is a warning message");
			Logger.getInstance().logError("This is a error message");
		}
		catch (UnableToReleaseTheConnection exp) {
			System.out.println("this is the exception :: " + exp.getMessage());
			exp.printStackTrace();
		}
		catch (ConnectionIsAlreadyReleased exp) {
			System.out.println("this is the exception :: " + exp.getMessage());
			exp.printStackTrace();
		}
		catch (connectionIsUse exp) {
			System.out.println("this is the exception :: " + exp.getMessage());
			exp.printStackTrace();
		}
		catch (Exception exp) {
			System.out.println("Unexpected Error :: " + exp.getMessage());
		}
	}

	public static void main(String[] args) throws Exception{
		Logger.getInstance().logInfo("This is a info message");
		Logger.getInstance().logDebug("This is a debug message");
		Logger.getInstance().logWarning("This is a warning message");
		Logger.getInstance().logError("This is a error message");
		
		Protocol ssh = Connection.getInstance(ConnectionType.SSH);
		Protocol ssh2 = Connection.getInstance(ConnectionType.SSH);
		Protocol telnet = Connection.getInstance(ConnectionType.TELNET);
		Protocol scp = Connection.getInstance(ConnectionType.SCP);
		Protocol ftp = Connection.getInstance(ConnectionType.FTP);
		
		
		
		if(ssh == ssh2) {
			System.out.println(" ssh is equal to ssh2");
		}
		
		sendExceptions(ssh," testing ssh ");
		
		System.out.println(Connection.getCurrentConnections());
		releaseExceptions(ConnectionType.SSH);
		System.out.println(Connection.getCurrentConnections());
		
		ftp = Connection.getInstance(ConnectionType.FTP);
		System.out.println(Connection.getCurrentConnections());	
		ssh = Connection.getInstance(ConnectionType.SSH);
		ftp = Connection.getInstance(ConnectionType.FTP);
		ftp = Connection.getInstance(ConnectionType.FTP);
		ftp = Connection.getInstance(ConnectionType.FTP);
		
		sendExceptions(ftp,"Testing FTP");
		
		releaseExceptions(ConnectionType.FTP);
		Protocol tftp = Connection.getInstance(ConnectionType.TFTP);
		Protocol tftp2 = Connection.getInstance(ConnectionType.TFTP);
		System.out.println(Connection.getCurrentConnections());
		if(tftp == tftp2 ) {
			System.out.println("Same object");
		}
		
		sendExceptions(tftp,"test the TFTP ");
		sendExceptions(tftp2,"test the TFTP ");
		
		System.out.println(Connection.getCurrentConnections());//3
		if(ftp == null) {
			System.out.println("FTP is a null");
			} else {
			System.out.println("FTP is not a null");
		}
		sendExceptions(ftp," breaking the logic ");
	}

	
		
		
}