package com.settleUp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.settleUp.entity.Group;
import com.settleUp.entity.User;
import com.settleUp.requestResponse.JsonResponse;
import com.settleUp.requestResponse.UserListResponse;
import com.settleUp.requestResponse.UsersDTO;
import com.settleUp.service.GroupService;
import com.settleUp.service.UserService;

/**
 * @author Vinayak Mumbai <vinayak.s.mumbai@gmail.com> Created on Dec 1, 2015
 */
@Controller
public class UsersController extends BaseController{

    @Autowired
    private UserService userService;


    /**
     * @param groupId
     * @return
     */
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public @ResponseBody UserListResponse getUsers(
            @RequestParam(value = "groupId", required = true) long groupId) {
        List<User> users = userService.findAll(groupId);
        UserListResponse response = new UserListResponse();
        response.setStaus(HttpStatus.OK);
        response.setMessage("Successful");
        response.setGroupId(groupId);
        if (users != null && !users.isEmpty()) {
            response.setUsers(convertToUserDTO(users));
        }
        return response;
    }
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public @ResponseBody JsonResponse createUser(@RequestBody UserListResponse request){
    	userService.creatUser(request);
    	JsonResponse response=new JsonResponse(HttpStatus.OK, "Created successfully");   	
		return response;
    	
    }

    private List<UsersDTO> convertToUserDTO(List<User> users) {
        List<UsersDTO> userDTOs = new ArrayList<UsersDTO>(users.size());
        for (User user : users) {
            UsersDTO u = new UsersDTO(user.getName(), user.getEmailId());
            if (!userDTOs.contains(u)) {
                userDTOs.add(u);
            }
        }
        return userDTOs;
    }

}
