//============================================================
//Copyright 2016, Drona, Inc. All rights reserved.
//============================================================
package com.settleUp.requestResponse;


public class PaymentUserDTO {

    private Long id;

    private Long amount;

    public PaymentUserDTO() {
        super();
    }

    public PaymentUserDTO(Long id, Long amount) {
        super();
        this.id = id;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

}
