package edu.najah.it.capp.exception;

public class SystemBusy extends ProtocolException{

	public SystemBusy(String message) {
		super(message);
	}
	
	@Override
	public String getMessage() {
		return "System Busy :: " + super.getMessage();
	} 
	
}
