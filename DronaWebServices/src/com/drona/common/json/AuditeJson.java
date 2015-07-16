//============================================================
//Copyright 2015, Drona, Inc. All rights reserved.
//============================================================
package com.drona.common.json;

import java.util.Calendar;
import java.util.GregorianCalendar;

import com.drona.common.CalenderUtil;


/**
 * @author Vinayak Mumbai <vinayak.s.mumbai@gmail.com> Created on Mar 23, 2015
 */
public class AuditeJson{

    private long createdBy;

    private String createdDate;

    private long lastModifiedBy;

    private String lastModifiedDate;

    public AuditeJson() {
        super();
    }

    public AuditeJson(long createdBy) {
        super();
        this.createdBy = createdBy;
        this.createdDate = CalenderUtil.getDate(new GregorianCalendar());
        this.lastModifiedBy = createdBy;
        this.lastModifiedDate = CalenderUtil.getDate(new GregorianCalendar());

    }

    public AuditeJson(long lastModifiedBy, Calendar lastModifiedDate) {
        super();
        this.lastModifiedBy = lastModifiedBy;
        this.lastModifiedDate = CalenderUtil.getDate(lastModifiedDate);
    }

    public long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(long createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public long getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(long lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public String getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(String lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }



}
