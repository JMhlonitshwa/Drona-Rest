package com.settleUp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.settleUp.entity.User;

@Component
@Transactional
public class UserService {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	public void save(User user){
		hibernateTemplate.save(user);
	}
	public void saveAll(List<User> users){
		for (User user : users) {
			hibernateTemplate.save(user);
		}		
	}
	public List<User> findAll(long groupId){
		String hql="select users from User users join users.groups g where g.groupId=:groupId";
		return (List<User>) hibernateTemplate.findByNamedParam(hql, "groupId", groupId);		
	}

}
