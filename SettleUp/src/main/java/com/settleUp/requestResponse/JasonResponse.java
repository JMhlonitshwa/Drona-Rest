package com.settleUp.requestResponse;

import org.springframework.http.HttpStatus;

public class JasonResponse {
private HttpStatus staus;
private String message;
public JasonResponse() {
	super();
}
public JasonResponse(HttpStatus staus, String message) {
	super();
	this.staus = staus;
	this.message = message;
}
public HttpStatus getStaus() {
	return staus;
}
public void setStaus(HttpStatus staus) {
	this.staus = staus;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}


}
