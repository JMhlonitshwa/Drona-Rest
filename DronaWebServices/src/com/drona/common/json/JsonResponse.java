//============================================================
//Copyright 2015, Drona, Inc. All rights reserved.
//============================================================
package com.drona.common.json;

/**
 * it base json response class
 * 
 * @author Vinayak Mumbai <vinayak.s.mumbai@gmail.com> Created on Mar 21, 2015
 */
public class JsonResponse {

    private String httpStatus;

    private String message;

    public JsonResponse() {
        super();
    }

    public JsonResponse(String status, String message) {
        super();
        this.httpStatus = status;
        this.message = message;
    }

    public String getHttpStatus () {
        return this.httpStatus ;
    }

    public void setHttpStatus(String status) {
        this.httpStatus  = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
