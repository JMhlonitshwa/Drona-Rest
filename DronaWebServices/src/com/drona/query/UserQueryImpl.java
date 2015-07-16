//============================================================
//Copyright 2015, Drona, Inc. All rights reserved.
//============================================================
package com.drona.query;

/**
 * @aut Vinayak Mumbai <vinayak.s.mumbai@gmail.com> Created on Mar 21, 2015015
 */
public class UserQueryImpl extends BaseQueryImpl {

    private static final String User_QUERY = "SELECT user FROM UserImpl user";

    private static final String User_COUNR_QUERY = "SELECT count(*) FROM UserImpl user";

    public UserQueryImpl() {
        super(User_QUERY, User_COUNR_QUERY);
    }

    public void filterByStatus(int statusId) {
        filterBy("user.auditData.status=" + statusId);
    }

    public void filterById(long id) {
        filterBy("user.userId=" + id);
    }

    public void filterByUserName(String username) {
        filterBy("user.username='" + username + "'");
    }




}
