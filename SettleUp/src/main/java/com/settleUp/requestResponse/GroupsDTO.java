//============================================================
//Copyright 2015, Drona, Inc. All rights reserved.
//============================================================
package com.settleUp.requestResponse;

import java.util.List;

import com.settleUp.entity.Group;

/**
 * 
 * @author Vinayak Mumbai <vinayak.s.mumbai@gmail.com> Created on Dec 1, 2015
 */
public class GroupsDTO {

    private Long groupId;

    private String groupName;

    List<UsersDTO> users;

    public GroupsDTO() {
        super();
    }

    public GroupsDTO(String groupName, List<UsersDTO> users) {
        super();
        this.groupName = groupName;
        this.users = users;
    }

    public GroupsDTO(Group group) {
        super();
        this.groupName = group.getGroupName();
        this.groupId = group.getGroupId();
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<UsersDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UsersDTO> users) {
        this.users = users;
    }

    
    public Long getGroupId() {
        return groupId;
    }

    
    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }


}
