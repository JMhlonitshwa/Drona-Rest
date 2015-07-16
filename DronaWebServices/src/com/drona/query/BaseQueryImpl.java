//============================================================
//Copyright 2015, Drona, Inc. All rights reserved.
//============================================================
package com.drona.query;

import com.drona.common.StringUtil;


/**
 * @author Vinayak Mumbai <vinayak.s.mumbai@gmail.com> Created on Mar 21, 2015
 */
public class BaseQueryImpl {

    private String query;

    private String countQuery;

    private static final String ADD_CLAUSE = " and ";

    private static final String WHERE_CLAUSE = " Where ";

    /**
     * @param query
     * @param countQuery
     */
    public BaseQueryImpl(String query, String countQuery) {
        super();
        this.query = query;
        if (!StringUtil.isEmptyOrBlank(countQuery)) {
            this.countQuery = countQuery;
        }
    }

    /**
     * 
     */
    public BaseQueryImpl() {
        super();
    }

    protected void addWhere(String condition) {
        this.query = getQuery() + WHERE_CLAUSE + condition;
        this.countQuery = getCountQuery() + WHERE_CLAUSE + condition;
    }

    protected void addAdd(String condition) {
        this.query = getQuery() + ADD_CLAUSE + condition;
        this.countQuery = getCountQuery() + ADD_CLAUSE + condition;
    }
    
    protected void filterBy(String filterBy){
        if (getQuery().matches(".* [Where].*")) {
            addAdd(filterBy);
        } else {
            addWhere(filterBy);
        }
    }

    public String getQuery() {
        return query;
    }


    public String getCountQuery() {
        return countQuery;
    }
    

}
