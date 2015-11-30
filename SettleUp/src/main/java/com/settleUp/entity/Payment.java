//============================================================
//Copyright 2015, Drona, Inc. All rights reserved.
//============================================================
package com.settleUp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author Vinayak Mumbai <vinayak.s.mumbai@gmail.com>
 * Created on Dec 1, 2015
 */
@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String paymentId;

    @ManyToOne
    @JoinColumn(name = "payedBy_id")
    private User payedBy;

    private Long amount;

    @ManyToOne
    @JoinColumn(name = "groupId")
    private Group group;

    public Payment() {
        super();
    }

    public Payment(String paymentId, User payedBy, Long amount, Group groupId) {
        super();
        this.paymentId = paymentId;
        this.payedBy = payedBy;
        this.amount = amount;
        this.group = groupId;
    }


    public String getPaymentId() {
        return paymentId;
    }


    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }


    public User getPayedBy() {
        return payedBy;
    }


    public void setPayedBy(User payedBy) {
        this.payedBy = payedBy;
    }


    public Long getAmount() {
        return amount;
    }


    public void setAmount(Long amount) {
        this.amount = amount;
    }


    public Group getGroup() {
        return group;
    }


    public void setGroup(Group groupId) {
        this.group = groupId;
    }


}
