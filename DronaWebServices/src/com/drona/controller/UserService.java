//============================================================
//Copyright 2015, Drona, Inc. All rights reserved.
//============================================================
package com.drona.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.drona.common.GenericRepository;
import com.drona.common.json.UserJson;

/**
 * @author Vinayak Mumbai <vinayak.s.mumbai@gmail.com>
 * Created on Mar 25, 2015
 */
@Component
public class UserService {

    @Autowired
    private GenericRepository genericRepository;

    /**
     * @param users
     * @param orgId
     */
    @Transactional
    public void createUsers(List<UserJson> users, Long orgId) {
        if(users!=null && !users.isEmpty()){
            //create user
        }

    }

}
