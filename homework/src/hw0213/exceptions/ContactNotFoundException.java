package hw0213.exceptions;

public class ContactNotFoundException extends RuntimeException {
	public ContactNotFoundException(String message) {
		super(message);
	}
}