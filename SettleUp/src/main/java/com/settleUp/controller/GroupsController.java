//============================================================
//Copyright 2015, Drona, Inc. All rights reserved.
//============================================================
package com.settleUp.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.settleUp.requestResponse.GroupsDTO;
import com.settleUp.requestResponse.GroupsResponse;
import com.settleUp.service.GroupService;


/**
 * @author Vinayak Mumbai <vinayak.s.mumbai@gmail.com> Created on Dec 1, 2015
 */
@Controller
public class GroupsController {
    private GroupService groupService;

    @RequestMapping(value = "/groups", method = RequestMethod.GET)
    public @ResponseBody GroupsResponse getGroupsCollection() {
        List<GroupsDTO> groups=groupService.getAllGroups();    
       
        return buildResponse(groups);

    }

    @RequestMapping(value = "/groups", method = RequestMethod.GET)
    public @ResponseBody GroupsResponse getGroupEntity(
            @RequestParam(value = "groupId", required = true) long groupId) {
        GroupsDTO group=groupService.getGroup(groupId);
        return buildResponse(Arrays.asList(group));

    }

    private GroupsResponse buildResponse(List<GroupsDTO> groups) {
        GroupsResponse response= new GroupsResponse();
        response.setStaus(HttpStatus.OK);
        response.setMessage("Success");
        if(groups!=null && !groups.isEmpty()){
            response.setGroups(groups);
        }
        return response;
    }

}
