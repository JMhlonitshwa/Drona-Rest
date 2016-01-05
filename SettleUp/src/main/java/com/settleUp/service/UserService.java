package com.settleUp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.settleUp.entity.Group;
import com.settleUp.entity.User;
import com.settleUp.requestResponse.UserListResponse;
import com.settleUp.requestResponse.UsersDTO;

/**
 * @author Vinayak Mumbai <vinayak.s.mumbai@gmail.com> Created on Dec 1, 2015
 */
@Component
@Transactional
public class UserService {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public void save(User user) {
        hibernateTemplate.save(user);

    }

    public void saveAll(List<User> users) {
        for (User user : users) {
            hibernateTemplate.save(user);
        }
    }

    public List<User> findAll(long groupId) {
        String hql = "select users from User users join users.groups g where g.groupId=:groupId";
        return (List<User>) hibernateTemplate.findByNamedParam(hql, "groupId", groupId);
    }

    public List<User> findAll(Set<Long> userIds) {
        StringBuilder userIdBuilder=new StringBuilder();
        int i=0;
        for (Long l : userIds) {
            userIdBuilder.append(l);
            i++;
            if(i<userIds.size()-1) {
                userIdBuilder.append(',');
            }
        }
        String hql = "select users from User users where users.userId in (" + userIdBuilder + ")";
        return (List<User>) hibernateTemplate.find(hql);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public void creatUser(UserListResponse request) {
        Group group = hibernateTemplate.get(Group.class, request.getGroupId());
        if (group == null) {
            throw new RuntimeException("Entity Not found for group id:" + request.getGroupId());
        }
        if (request.getUsers() != null && !request.getUsers().isEmpty()) {
            List<User> users = new ArrayList<User>(request.getUsers().size());
            for (UsersDTO user : request.getUsers()) {
                User u = new User(user.getEmail(), user.getName());
                users.add(u);
            }
            group.setUsers(findAll(request.getGroupId()));
            group.getUsers().addAll(users);
            hibernateTemplate.saveOrUpdate(group);

        }

    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW, rollbackFor = { Exception.class })
    public void saveGroup(Group group) throws Exception {
        hibernateTemplate.saveOrUpdate(group);
        System.out.println("saved or update");
    }


}
