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

@Entity
public class PaymentUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Payment paymentId;

    @ManyToOne
    @JoinColumn(name = "payed_for_id")
    private User payedFor;

    private Long payableAmount;

    public PaymentUser() {
        super();
    }

    public PaymentUser(Long id, Payment paymentId, User payedFor, Long payableAmount) {
        super();
        this.id = id;
        this.paymentId = paymentId;
        this.payedFor = payedFor;
        this.payableAmount = payableAmount;
    }

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Payment getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Payment paymentId) {
        this.paymentId = paymentId;
    }

    public User getPayedFor() {
        return payedFor;
    }

    public void setPayedFor(User user) {
        this.payedFor = user;
    }

    public Long getPayableAmount() {
        return payableAmount;
    }

    public void setPayableAmount(Long payableAmount) {
        this.payableAmount = payableAmount;
    }

}
