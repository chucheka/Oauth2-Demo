package net.polaris.Oauth2_Demo.payload;

import java.util.List;

import org.springframework.http.HttpStatus;

public class ErrorResponse {

	private HttpStatus status;
	
	private String message;
	
	private List<String> errors;

	public ErrorResponse() {
		
	}

	public ErrorResponse(HttpStatus status, String message, List<String> errors) {
		super();
		this.status = status;
		this.message = message;
		this.errors = errors;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	
}
