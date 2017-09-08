package com.cgm.assignment5spring.dto;

public class ServiceResponse {
	private String message = "Operation successful!";
	private int code = 200;
	
	public ServiceResponse() {
		
	}
	
	public ServiceResponse(String message, int code) {
		this.message = message;
		this.code = code;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public int getCode() {
		return code;
	}
	
	public void setCode(int code) {
		this.code = code;
	}
}
