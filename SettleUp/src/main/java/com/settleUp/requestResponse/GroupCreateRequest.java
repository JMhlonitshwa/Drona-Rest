package com.settleUp.requestResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vinayak Mumbai <vinayak.s.mumbai@gmail.com> Created on Dec 1, 2015
 */
public class GroupCreateRequest {

    private String groupName;

    private List<UsersDTO> users = new ArrayList<UsersDTO>();

    /**
     * 
     */
    public GroupCreateRequest() {
        super();
    }

    public GroupCreateRequest(String groupName, List<UsersDTO> users) {
        super();
        this.groupName = groupName;
        this.users = users;
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

}
