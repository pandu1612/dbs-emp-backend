package com.emp.project.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;

public class ErrorDetails {
	private Date timestamp;
	private String message;
	private String details;
	private HttpStatus httpstatus;

	public ErrorDetails(Date timestamp, String message, String details, HttpStatus httpstatus) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
		this.setHttpstatus(httpstatus);
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}

	public HttpStatus getHttpstatus() {
		return httpstatus;
	}

	public void setHttpstatus(HttpStatus httpstatus) {
		this.httpstatus = httpstatus;
	}
}