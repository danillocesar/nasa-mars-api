package com.mars.api.marsapi.rest.response;

public class ErrorData {
	private String field;
	private Object parameter;
	private String error;
	private String message;

	public ErrorData(String field, String error, String message, Object parameter) {
		super();
		this.field = field;
		this.error = error;
		this.message = message;
		this.parameter = parameter;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getParameter() {
		return parameter;
	}

	public void setParameter(Object parameter) {
		this.parameter = parameter;
	}

}
