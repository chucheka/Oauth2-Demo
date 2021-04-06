package net.polaris.Oauth2_Demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class AuthenticationFailedException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AuthenticationFailedException(String message) {
        super(message);
    }

    public AuthenticationFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}