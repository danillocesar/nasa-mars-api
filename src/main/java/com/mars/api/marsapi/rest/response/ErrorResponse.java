package com.mars.api.marsapi.rest.response;

import java.util.List;

public class ErrorResponse {
	private String message;
	private String error;
	private List<ErrorData> errors;
	private Object data;

	public ErrorResponse(String message, String error) {
		this.message = message;
		this.error = error;
	}

	public ErrorResponse(String message, String error, List<ErrorData> errors) {
		this.message = message;
		this.error = error;
		this.errors = errors;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public List<ErrorData> getErrors() {
		return errors;
	}

	public void setErrors(List<ErrorData> errors) {
		this.errors = errors;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	

}