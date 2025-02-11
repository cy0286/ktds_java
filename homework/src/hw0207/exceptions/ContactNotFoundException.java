package hw0207.exceptions;

public class ContactNotFoundException extends RuntimeException{

	public ContactNotFoundException(String message) {
		super(message);
	}
}
