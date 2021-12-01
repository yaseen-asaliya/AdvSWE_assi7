package edu.najah.it.capp.exception;

public class ConnectionIsAlreadyReleased extends ProtocolException{

	public ConnectionIsAlreadyReleased(String message) {
		super(message);
	}
	
	@Override
	public String getMessage() {
		return "Connection is already released :: " + super.getMessage();
	}


}
