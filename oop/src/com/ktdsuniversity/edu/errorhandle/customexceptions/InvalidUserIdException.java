package com.ktdsuniversity.edu.errorhandle.customexceptions;

public class InvalidUserIdException extends RuntimeException {

	public InvalidUserIdException(String message) {
		super(message);
	}
}