//============================================================
//Copyright 2015, Drona, Inc. All rights reserved.
//============================================================
package com.drona.controller.organisation;

import com.drona.common.json.AddressJson;
import com.drona.common.json.AuditeJson;


/**
 * @author Vinayak Mumbai <vinayak.s.mumbai@gmail.com> Created on Apr 6, 2015
 */
public class InstituteJson {

    private long id;

    private String name;

    private String status;

    private AuditeJson auditData;

    private AddressJson address;

    public InstituteJson() {
        super();
    }

    public InstituteJson(long id, String name, String status, Long createdBy) {
        this.id = id;
        this.name = name;
        this.status = status;
        if (createdBy != null) {
            setAuditData(new AuditeJson(createdBy));
        }
    }


    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getStatus() {
        return status;
    }


    public void setStatus(String status) {
        this.status = status;
    }


    public AddressJson getAddress() {
        return address;
    }


    public void setAddress(AddressJson address) {
        this.address = address;
    }


    public AuditeJson getAuditData() {
        return auditData;
    }


    public void setAuditData(AuditeJson auditData) {
        this.auditData = auditData;
    }



}
