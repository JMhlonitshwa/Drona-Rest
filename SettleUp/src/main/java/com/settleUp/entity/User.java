//============================================================
//Copyright 2015, Drona, Inc. All rights reserved.
//============================================================
package com.settleUp.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


/**
 * @author Vinayak Mumbai <vinayak.s.mumbai@gmail.com> Created on Nov 30, 2015
 */
@Entity
@Table(name = "User")
public class User {

    @Id
    private String emailId;

    private String name;

    @ManyToMany()
    @JoinTable(name = "User_Group", joinColumns = { @JoinColumn(name = "emailId") }, inverseJoinColumns = { @JoinColumn(name = "groupId") })
    private List<Group> groups = new ArrayList<Group>();

    public User() {

    };

    public User(String emailId, String name) {
        this.emailId = emailId;
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<Group> getGroups() {
        return groups;
    }


    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }


}
