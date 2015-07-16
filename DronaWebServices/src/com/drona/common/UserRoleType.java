//============================================================
//Copyright 2015, Drona, Inc. All rights reserved.
//============================================================
package com.drona.common;


public enum UserRoleType {
    ADMIN(1, "Admin"), ORG_ADMIN(2, "Org_Admin"), PRINCIPAL(3, "Principal"), TEACHER(4, "Teacher"), NON_TEACHER(
            5, "Non_Teacher"), STUDENT(6, "Student"), PARENT(7, "Parent");

    private long id;

    private String roleType;

    private UserRoleType(long id, String roleType) {
        this.id = id;
        this.roleType = roleType;
    }

    public long getId() {
        return id;
    }

    public String getRoleType() {
        return roleType;
    }

}
