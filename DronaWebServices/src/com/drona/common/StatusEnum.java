//============================================================
//Copyright 2015, Drona, Inc. All rights reserved.
//============================================================
package com.drona.common;

import com.drona.common.exception.ApplicationException;


public enum StatusEnum {
    CREATED(1, "Created"), ACTIVE(2, "Active"), INACTIVE(3, "Inactive"), DELETED(4, "Deleted");

    private int id;

    private String status;

    private StatusEnum(int id, String status) {
        this.id = id;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public static StatusEnum getStatusEnum(int id) {
        StatusEnum e = null;
        for (StatusEnum status : StatusEnum.values()) {
            if (status.getId() == id) {
                e = status;
            }

        }
        if (e == null) {
            throw new ApplicationException("Invalid Status");
        }
        return e;
    }

    
}
