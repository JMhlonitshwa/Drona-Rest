//============================================================
//Copyright 2015, Drona, Inc. All rights reserved.
//============================================================
package com.settleUp.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.settleUp.entity.Group;
import com.settleUp.entity.User;
import com.settleUp.requestResponse.GroupCreateRequest;
import com.settleUp.requestResponse.GroupsDTO;
import com.settleUp.requestResponse.UsersDTO;

/**
 * @author Vinayak Mumbai <vinayak.s.mumbai@gmail.com> Created on Dec 1, 2015
 */
@Component
@Transactional
public class GroupService {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    /**
     * @return
     */
    public List<GroupsDTO> getAllGroups() {
        List<Group> groups = hibernateTemplate.loadAll(Group.class);
        List<GroupsDTO> groupsDTOs = new ArrayList<GroupsDTO>(groups.size());
        for (Group group : groups) {
            groupsDTOs.add(new GroupsDTO(group));
        }
        return groupsDTOs;
    }

   
    /**
     * @param groupId
     * @return
     * @throws Exception 
     */
    public GroupsDTO getGroup(long groupId) throws Exception {
        Group group = hibernateTemplate.get(Group.class, groupId);
        if(group==null){
            throw new Exception("Entity not found for Group id:" + groupId);
        }
        return new GroupsDTO(group);
    }

    /**
     * @param request
     */
    public void createGroup(GroupCreateRequest request) {
        Group group = new Group();
        group.setGroupName(request.getGroupName());
        for (UsersDTO user : request.getUsers()) {
            User u=new User(user.getEmail(), user.getName());
            group.getUsers().add(u);
        }
        hibernateTemplate.save(group);

    }

}
