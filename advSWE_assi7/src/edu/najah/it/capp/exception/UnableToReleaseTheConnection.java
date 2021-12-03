package edu.najah.it.capp.exception;

public class UnableToReleaseTheConnection extends ProtocolException{

	public UnableToReleaseTheConnection(String message) {
		super(message);
	}
	
	@Override
	public String getMessage() {
		return "Unable to release the connection  :: " + super.getMessage();
	}

}
