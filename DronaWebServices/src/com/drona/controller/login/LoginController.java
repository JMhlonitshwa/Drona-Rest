//============================================================
//Copyright 2015, Drona, Inc. All rights reserved.
//============================================================
package com.drona.controller.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.drona.common.exception.ServiceException;
import com.drona.common.json.JsonResponse;
import com.drona.controller.BaseController;


/**
 * Login Controller to handle login api
 * 
 * @author Vinayak Mumbai <vinayak.s.mumbai@gmail.com> Created on Mar 21, 2015
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController extends BaseController {

    private static final Logger logger = Logger.getLogger(LoginController.class);

    @Autowired
    private LoginService loginService;

    /**
     * validate the user and returns the session
     * 
     * @param request
     * @param httpRequest
     * @return
     * @throws ServiceException
     */
    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    LoginResponse login(@RequestBody LoginRequest request, HttpServletRequest httpRequest)
            throws ServiceException {
        logger.info("Login api is hit!");
        // TODO: vaidate the request,
        // if valid send it to service class
        LoginResponse response =
            loginService.validateUser(request.getUsername(), request.getPassword(), httpRequest);
        return response;

    }

    /**
     * 
     * @param userId
     * @return
     * @throws ServiceException
     */
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    JsonResponse logout(@RequestParam(value = "userId", required = true) long userId,
            HttpSession session) throws ServiceException {
        // TODO: validate here
        if (session != null) {
            session.invalidate();
            return loginService.logout(userId);
        }
        return null;


    }



}
