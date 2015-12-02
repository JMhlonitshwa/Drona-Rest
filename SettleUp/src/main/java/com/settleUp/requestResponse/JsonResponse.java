package com.settleUp.requestResponse;

import org.springframework.http.HttpStatus;

public class JsonResponse {
private HttpStatus staus;
private String message;
public JsonResponse() {
	super();
}
public JsonResponse(HttpStatus staus, String message) {
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
