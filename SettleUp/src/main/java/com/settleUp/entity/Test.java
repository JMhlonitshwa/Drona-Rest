package com.settleUp.entity;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.settleUp.service.UserService;

public class Test {
	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("root-context.xml");
UserService userService= (UserService) ctx.getBean("userService");
//userService.save(new User("Test", "Test"));
		
	}

}
