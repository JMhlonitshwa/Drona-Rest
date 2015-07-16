package com.drona.common;


/**
 * @author Vinayak Mumbai <vinayak.s.mumbai@gmail.com> Created on Mar 25, 2015
 */
public class UserContext {

    private long userId;

    private long orgId;

    public UserContext(long userId, long orgId) {
        super();
        this.userId = userId;
        this.orgId = orgId;

    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getOrgId() {
        return orgId;
    }

    public void setOrgId(long orgId) {
        this.orgId = orgId;
    }



}
