//============================================================
//Copyright 2016, Drona, Inc. All rights reserved.
//============================================================
package com.settleUp.service;


import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.settleUp.entity.Group;
import com.settleUp.entity.Payment;
import com.settleUp.entity.PaymentUser;
import com.settleUp.entity.User;
import com.settleUp.requestResponse.PaymentDTO;
import com.settleUp.requestResponse.PaymentRequest;
import com.settleUp.requestResponse.PaymentResponse;
import com.settleUp.requestResponse.PaymentUserDTO;
import com.settleUp.requestResponse.UsersDTO;

@Component
@Transactional
public class PaymentServices {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Autowired
    private UserService userService;

    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public void createPayment(PaymentRequest request) {
        Group group=hibernateTemplate.load(Group.class, request.getGroupId());
        Map<Long,User> usersMap=populateMap(userService.findAll(request.getGroupId()));
        Payment payment=new Payment();
        payment.setAmount(request.getTotalAmount());
        payment.setGroup(group);
        payment.setPayedBy(usersMap.get(request.getPayedBy()));
        payment.setNote(request.getNote());
        for (PaymentUserDTO user : request.getPaymentUsers()) {
            payment.getPayedForUser().add(new PaymentUser(usersMap.get(user.getUserId()), user.getAmount(),payment));
        }
       hibernateTemplate.save(payment);

    }

    private Map<Long, User> populateMap(List<User> users) {
        Map<Long, User> map=new HashMap<Long, User>();
        for (User user : users) {
            map.put(user.getUserId(), user);
        }
        return map;
    }
    public  PaymentResponse getPayments(Long groupId) {
    	List<Payment> payments=getPaymentsForGroup(groupId);
    	PaymentResponse response=new PaymentResponse(payments.size());
    	response.setStaus(HttpStatus.OK);    	
    	if(payments!=null && !payments.isEmpty()){
    	Set<Long> userIds=new HashSet<Long>();
    	for (Payment p : payments) {
			userIds.add(p.getPayedBy().getUserId());
		}
    	Map<Long,User> usersMap=populateMap(userService.findAll(userIds));    	
    	for (Payment  p : payments) {
    		User u=usersMap.get(p.getPayedBy().getUserId());
			UsersDTO user=new UsersDTO(u.getUserId(),u.getName(), u.getEmailId());
			PaymentDTO p_DTO=new PaymentDTO();
			p_DTO.setAmount(p.getAmount());
			p_DTO.setNote(p.getNote());			
			p_DTO.setPayedBy(user);
			p_DTO.setPaymentId(p.getPaymentId());
			response.getPayments().add(p_DTO);
		}
    	}else{
    		response.setMessage("no payments are added"); 
    	}
		return response;
    	
    }

    public  List<Payment> getPaymentsForGroup(Long groupId) {
      // get payment
    	List<Payment> payment=(List<Payment>) hibernateTemplate.findByNamedParam("select p from Payment p join p.group g where g.groupId=:groupId", "groupId", groupId);
    	
        return payment;
    }
}
