//============================================================
//Copyright 2015, Drona, Inc. All rights reserved.
//============================================================
package com.drona.controller.organisation;

import java.util.ArrayList;
import java.util.List;

import com.drona.common.json.AddressJson;
import com.drona.common.json.UserJson;


/**
 * 
 * @author Vinayak Mumbai <vinayak.s.mumbai@gmail.com> Created on Mar 24, 2015
 */
public class OrganisationJsonRequest {

    private String OrgnaistaionName;

    private String parentOrgId;    
    
    private AddressJson address;

    private List<UserJson> users = new ArrayList<UserJson>();

    public String getOrgnaistaionName() {
        return OrgnaistaionName;
    }

    public void setOrgnaistaionName(String orgnaistaionName) {
        OrgnaistaionName = orgnaistaionName;
    }

    public String getParentOrgId() {
        return parentOrgId;
    }


    public void setParentOrgId(String parentOrgId) {
        this.parentOrgId = parentOrgId;
    }

    public AddressJson getAddress() {
        return address;
    }

    public void setAddress(AddressJson address) {
        this.address = address;
    }

    public List<UserJson> getUsers() {
        return users;
    }

    public void setUsers(List<UserJson> users) {
        this.users = users;
    }


}
