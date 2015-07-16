//============================================================
//Copyright 2015, Drona, Inc. All rights reserved.
//============================================================
package com.drona.query;

/**
 * @author Vinayak Mumbai <vinayak.s.mumbai@gmail.com> Created on Mar 21, 2015
 */
public class SessionQueryImpl extends BaseQueryImpl {

    private static final String SESSION_QUERY = "SELECT s FROM SessionImpl s";

    /**
     * Query constructor
     */
    public SessionQueryImpl() {
        super(SESSION_QUERY, null);
    }

    public void filterByUserId(long userId) {
        filterBy("s.userId=" + userId);       
    }
   

}
