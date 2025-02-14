package hw0213.exceptions;

public class ContactAppException extends RuntimeException {
	public ContactAppException(String message, Throwable cause) {
		super(message, cause);
	}
}