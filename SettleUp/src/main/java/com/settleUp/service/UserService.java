package com.settleUp.service;

import java.util.ArrayList;
import java.util.List;

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
    
@Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
	public void creatUser(UserListResponse request) {
	Group group=hibernateTemplate.get(Group.class, request.getGroupId());
		if(group==null){
			throw new RuntimeException("Entity Not found for group id:"+ request.getGroupId());
		}
		if(request.getUsers()!=null && !request.getUsers().isEmpty()){
			List<User> users=new ArrayList<User>(request.getUsers().size());
			for (UsersDTO user : request.getUsers()) {
				User u=new User(user.getEmail(), user.getName());
				users.add(u);				
			}
			group.setUsers(findAll(request.getGroupId()));
			group.getUsers().addAll(users);
			hibernateTemplate.save(group);
		}
		
	}
   

}
