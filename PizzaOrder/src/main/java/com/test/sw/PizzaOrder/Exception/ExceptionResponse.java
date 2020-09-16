package com.test.sw.PizzaOrder.Exception;

import java.util.Date;

public class ExceptionResponse {
	private String message;
	private Date timestamp;
	private String Details;
	public String getMessage() {
		return message;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public String getDetails() {
		return Details;
	}
	public ExceptionResponse(String message, Date timestamp, String details) {
		super();
		this.message = message;
		this.timestamp = timestamp;
		Details = details;
	}
}
