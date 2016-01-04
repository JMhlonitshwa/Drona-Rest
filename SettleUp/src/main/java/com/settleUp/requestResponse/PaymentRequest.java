//============================================================
//Copyright 2016, Drona, Inc. All rights reserved.
//============================================================
package com.settleUp.requestResponse;

import java.util.ArrayList;
import java.util.List;


public class PaymentRequest {

    private Long groupId;

    private Long payedBy;

    private Long totalAmount;

    List<PaymentUserDTO> paymentUsers = new ArrayList<PaymentUserDTO>();

    public PaymentRequest() {
        super();
    }

    public PaymentRequest(Long groupId, Long payedBy, Long totalAmount) {
        super();
        this.groupId = groupId;
        this.payedBy = payedBy;
        this.totalAmount = totalAmount;
    }

    
    public Long getGroupId() {
        return groupId;
    }

    
    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    
    public Long getPayedBy() {
        return payedBy;
    }

    
    public void setPayedBy(Long payedBy) {
        this.payedBy = payedBy;
    }

    
    public Long getTotalAmount() {
        return totalAmount;
    }

    
    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }

    
    public List<PaymentUserDTO> getPaymentUsers() {
        return paymentUsers;
    }

    
    public void setPaymentUsers(List<PaymentUserDTO> paymentUsers) {
        this.paymentUsers = paymentUsers;
    }


}
