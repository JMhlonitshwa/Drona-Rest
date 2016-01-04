package com.settleUp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


import com.settleUp.requestResponse.JsonResponse;

public abstract class BaseController {
//	@ExceptionHandler({ RuntimeException.class })
//	@ResponseBody
//	public JsonResponse handleException(Exception e) {
//		JsonResponse response = new JsonResponse();
//		response.setStaus(HttpStatus.OK);
//		response.setMessage(e.getMessage());
//		return response;
//	}
}
