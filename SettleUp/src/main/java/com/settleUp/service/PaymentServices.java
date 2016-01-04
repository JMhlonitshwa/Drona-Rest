//============================================================
//Copyright 2016, Drona, Inc. All rights reserved.
//============================================================
package com.settleUp.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.settleUp.entity.Group;
import com.settleUp.entity.Payment;
import com.settleUp.entity.PaymentUser;
import com.settleUp.entity.User;
import com.settleUp.requestResponse.PaymentRequest;
import com.settleUp.requestResponse.PaymentUserDTO;

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

    public void getPayments(Long groupId) {
        // TODO Auto-generated method stub
        
    }
}
