package edu.najah.it.capp.logger;

import edu.najah.it.capp.asd.Demo;
import edu.najah.it.capp.exception.ProtocolException;
import edu.najah.it.capp.exception.debugException;
import edu.najah.it.capp.exception.errorException;
import edu.najah.it.capp.exception.infoException;
import edu.najah.it.capp.exception.warningException;

public class Logger {
	private static Logger instance; 
	private Logger() {}

	public static Logger getInstance() {
		if(instance == null) {
			instance = new Logger();
		}
		return instance;
	}
	
	// it try my hard to solve errors but im so weak in java cause of im 119 and we did't take java   
	public void logInfo(String message) throws ProtocolException {
		try {
			System.out.println(java.time.LocalDateTime.now()  + " [INFO] " + message);
		} 
		catch (infoException exp) {
			throw new infoException("this is exception :: " + exp.getMessage());
		}
	}
	
	public void logDebug(String message) throws ProtocolException{
		try {
			System.out.println(java.time.LocalDateTime.now()  + " [Debug] " + message);
		} catch(debugException exp) {
			throw new infoException("this is exception :: " + exp.getMessage());

		}
s
	}
	
	public void logWarning(String message) throws ProtocolException{
		try {
			System.err.println(java.time.LocalDateTime.now()  + " [Warn] " + message);
		} catch(warningException exp) {
			throw new warningException("this is exception :: " + exp.getMessage());
		}
	}
	
	public void logError(String message) throws ProtocolException{
		try {
			System.err.println(java.time.LocalDateTime.now()  + " [Error] " + message);
		}catch(errorException exp) {
			throw new errorException("this is exception :: " + exp.getMessage());

		}
	}

}
