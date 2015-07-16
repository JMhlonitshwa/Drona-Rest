//============================================================
//Copyright 2015, Drona, Inc. All rights reserved.
//============================================================
package com.drona.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SESSION_DETAILS")
public class SessionImpl {

    @Id
    private long userId;

    private String sessionId;

    private String token;
    
    public SessionImpl(long userId, String sessionId, String token) {
        super();
        this.userId = userId;
        this.sessionId = sessionId;
        this.token = token;
    }
    
    public SessionImpl() {
        super();
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
