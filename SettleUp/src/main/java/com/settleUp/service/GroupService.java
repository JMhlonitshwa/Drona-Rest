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
import com.settleUp.requestResponse.GroupsDTO;

/**
 * @author Vinayak Mumbai <vinayak.s.mumbai@gmail.com> Created on Dec 1, 2015
 */
@Component
@Transactional
public class GroupService {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public List<GroupsDTO> getAllGroups() {
        List<Group> groups = hibernateTemplate.loadAll(Group.class);
        List<GroupsDTO> groupsDTOs = new ArrayList<GroupsDTO>(groups.size());
        for (Group group : groups) {
            groupsDTOs.add(new GroupsDTO(group));
        }
        return groupsDTOs;
    }

    public GroupsDTO getGroup(long groupId) {
        Group group;
        try {
            group = hibernateTemplate.get(Group.class, groupId);
        } catch (Exception e) {
            throw new RuntimeException("Entity not found for Group id:" + groupId, e);
        }
        return new GroupsDTO(group);
    }

}
