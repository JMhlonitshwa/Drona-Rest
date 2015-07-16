//============================================================
//Copyright 2015, Drona, Inc. All rights reserved.
//============================================================
package com.drona.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.drona.common.exception.ServiceException;
import com.drona.common.json.JsonResponse;


public class BaseController {
   
    @ExceptionHandler(value = {ServiceException.class })
    private @ResponseBody
    JsonResponse handleException(Exception e) {
        JsonResponse response = new JsonResponse();
        response.setHttpStatus(HttpStatus.OK.toString());
        response.setMessage(e.getMessage());

        return response;
    }
}
