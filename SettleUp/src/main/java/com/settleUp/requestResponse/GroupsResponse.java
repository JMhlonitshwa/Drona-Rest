//============================================================
//Copyright 2015, Drona, Inc. All rights reserved.
//============================================================
package com.settleUp.requestResponse;

import java.util.List;


public class GroupsResponse extends JasonResponse {
    List<GroupsDTO> groups;

    public GroupsResponse() {
        super();
    }

    public GroupsResponse(List<GroupsDTO> groups) {
        super();
        this.groups = groups;
    }

    
    public List<GroupsDTO> getGroups() {
        return groups;
    }

    
    public void setGroups(List<GroupsDTO> groups) {
        this.groups = groups;
    }
    
    

}
