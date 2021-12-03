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
	public static void main(String[] args) throws Exception{
		/*
	    i used them down
		Logger.getInstance().logInfo("This is a info message");
		Logger.getInstance().logDebug("This is a debug message");
		Logger.getInstance().logWarning("This is a warning message");
		Logger.getInstance().logError("This is a error message");
		*/
		
		Logger.getInstance().logDebug("start creation protocols ...");
		Protocol ssh = Connection.getInstance(ConnectionType.SSH);
		Protocol ssh2 = Connection.getInstance(ConnectionType.SSH);
		Protocol telnet = Connection.getInstance(ConnectionType.TELNET);
		Protocol scp = Connection.getInstance(ConnectionType.SCP);
		Protocol ftp = Connection.getInstance(ConnectionType.FTP);
		Logger.getInstance().logDebug("creation protocols has been ended...");

		try {
			Logger.getInstance().logInfo("compair btw 2 protocols ..");
			if(ssh == ssh2) {
				System.out.println(" ssh is equal to ssh2");
			}
			
			ssh.send(" testing ssh ");
			telnet.send("Testing telnet ");
			scp.send("Testing scp");
			System.out.println(Connection.getCurrentConnections());
			
			Logger.getInstance().logWarning("warning message : you are releaseing a protocol");
			Connection.release(ConnectionType.SSH);
			System.out.println(Connection.getCurrentConnections());
			
			ftp = Connection.getInstance(ConnectionType.FTP);
			System.out.println(Connection.getCurrentConnections());		
			
			Logger.getInstance().logInfo("reconnection a protocols ....");
			ssh = Connection.getInstance(ConnectionType.SSH);
			ftp = Connection.getInstance(ConnectionType.FTP);
			ftp = Connection.getInstance(ConnectionType.FTP);			
			ftp = Connection.getInstance(ConnectionType.FTP);
			ftp.send("Testing FTP");
			
			Logger.getInstance().logWarning("warning message : you are releaseing a protocol");
			Connection.release(ConnectionType.FTP);		
			
			Logger.getInstance().logDebug("start creation protocols ...");
			Protocol tftp = Connection.getInstance(ConnectionType.TFTP);
			Protocol tftp2 = Connection.getInstance(ConnectionType.TFTP);
			Logger.getInstance().logDebug("creation protocols has been ended...");

			System.out.println(Connection.getCurrentConnections());
			
			Logger.getInstance().logInfo("compair oparation ..");
			if(tftp == tftp2 ) {
				System.out.println("Same object");
			}
			tftp.send("test the TFTP ");
			tftp2.send("test the TFTP ");

			System.out.println(Connection.getCurrentConnections());//3
			
			Logger.getInstance().logInfo("compair oparation ..");
			if(ftp == null) {
				System.out.println("FTP is a null");
			} else {
				System.out.println("FTP is not a null");
			}
			ftp.send(" breaking the logic ");
		}
		catch (NoConnection exp) {
			Logger.getInstance().logError(exp.getMessage());
			System.out.println("Exception :: " + exp.getMessage());
		}
		catch (timeoutConnection exp) {
			Logger.getInstance().logError(exp.getMessage());
			System.out.println("Exception :: " + exp.getMessage());
		}
		catch (SystemBusy exp) {
			Logger.getInstance().logError(exp.getMessage());
			System.out.println("Exception :: " + exp.getMessage());
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		catch (UnableToReleaseTheConnection exp) {
			Logger.getInstance().logError(exp.getMessage());
			System.out.println("Exception :: " + exp.getMessage());
		}
		catch (ConnectionIsAlreadyReleased exp) {
			Logger.getInstance().logError(exp.getMessage());
			System.out.println("Exception :: " + exp.getMessage());
		}
		catch (connectionIsUse exp) {
			Logger.getInstance().logError(exp.getMessage());
			System.out.println("Exception :: " + exp.getMessage());
		}
		catch (Exception exp) {
			Logger.getInstance().logError(exp.getMessage());
			System.out.println("Exception :: " + exp.getMessage());
		}
		finally {
			// To make sure the connection is always released after it is no longer needed.
			ssh.release();
			ssh2.release();
			telnet.release();
			scp.release();
			ftp.release();
		}
	}	
		
		
}