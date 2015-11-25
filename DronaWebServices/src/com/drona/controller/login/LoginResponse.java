//============================================================
//Copyright 2015, Drona, Inc. All rights reserved.
//============================================================
package com.drona.controller.login;

import org.springframework.http.HttpStatus;

import com.drona.common.Constants;
import com.drona.common.json.JsonResponse;


/**
 * 
 * @author Vinayak Mumbai <vinayak.s.mumbai@gmail.com> Created on Mar 21, 2015
 */
public class LoginResponse extends JsonResponse {

    private long userId;

    private String sessionId;    

    private String token;
    
    public LoginResponse() {
        super();
    }

    public LoginResponse(long userId, String sessionId, String token) {
        super(HttpStatus.OK.toString(),Constants.VALID_USER);
        this.userId = userId;
        this.sessionId = sessionId;
        this.token = token;
    }


    public long getUserId() {
        return userId;
    }


    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


}
