//============================================================
//Copyright 2015, Drona, Inc. All rights reserved.
//============================================================
package com.drona.mBeans;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;

/**
 * @author Vinayak Mumbai <vinayak.s.mumbai@gmail.com> Created on Mar 26, 2015
 */
@ManagedResource(objectName = "com.drona.mBeans:type=Configuration,name=SystemConfigMbean", description = "To store application related data")
public class SystemMBean {

    private long sessionTimeOut;

    @ManagedAttribute
    public long getSessionTimeOut() {
        return sessionTimeOut;
    }

    @ManagedAttribute
    public void setSessionTimeOut(long sessionTimeOut) {
        this.sessionTimeOut = sessionTimeOut;
    }



}
