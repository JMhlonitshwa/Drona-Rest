//============================================================
//Copyright 2016, Drona, Inc. All rights reserved.
//============================================================
package com.settleUp.requestResponse;


public class PaymentUserDTO {

    private Long userId;

    private Long amount;

    public PaymentUserDTO() {
        super();
    }

    public PaymentUserDTO(Long userId, Long amount) {
        super();
        this.userId = userId;
        this.amount = amount;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

}
