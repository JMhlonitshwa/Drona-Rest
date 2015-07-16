//============================================================
//Copyright 2015, Drona, Inc. All rights reserved.
//============================================================
package com.drona.controller.login;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.drona.common.Constants;
import com.drona.common.GenericRepository;
import com.drona.common.StringUtil;
import com.drona.common.exception.EnityNotFoundException;
import com.drona.common.exception.PersistanceException;
import com.drona.common.exception.ServiceException;
import com.drona.common.json.JsonResponse;
import com.drona.entity.SessionImpl;
import com.drona.entity.UserImpl;
import com.drona.query.SessionQueryImpl;
import com.drona.query.UserQueryImpl;

/**
 * service class for login controller
 * 
 * @author Vinayak Mumbai <vinayak.s.mumbai@gmail.com> Created on Mar 23, 2015
 */
@Component
public class LoginService {
    private static final Logger logger= Logger.getLogger(LoginService.class);

    private static final String INVALID_USER = "Invalid User name or password";

    private static final String MESSAGE = "Invalid UserId";

    private static final int START_INDEX = 0;

    private static final int END_INDEX = 5;

    @Autowired
    private GenericRepository genericRepository;

    /**
     * it will validate the user and creates the session and token. save the details in
     * session_details table
     * 
     * @param username
     * @param password
     * @param httpRequest
     * @return LoginResponse
     * @throws ServiceException
     */
    @Transactional
    public LoginResponse validateUser(String username, String password,
            HttpServletRequest httpRequest) throws ServiceException {
        logger.info("validating the User:"+ username);
        LoginResponse response = null;
        UserQueryImpl query = new UserQueryImpl();
        query.filterByUserName(username);
        try {
            UserImpl user = (UserImpl) genericRepository.findSingle(query.getQuery());
            if (!StringUtil.isEmptyOrBlank(user.getPassword())
                && user.getPassword().equals(password)) {
                HttpSession session = httpRequest.getSession(true);
                session.setAttribute(Constants.USERID, user.getUserId());
                String token = generateToken(session.getId(), user.getUserId());
                response = new LoginResponse(user.getUserId(), session.getId(), token);
            } else {
                response = new LoginResponse();
                response.setMessage(INVALID_USER);
                response.setHttpStatus(HttpStatus.BAD_REQUEST.toString());
            }
        } catch (EnityNotFoundException e) {
            logger.info("User not found for username:"+ username);
            throw new ServiceException(INVALID_USER, e);
        }
        return response;
    }

    /**
     * @param userId
     * @return JsonResponse
     * @throws ServiceException
     */
    public JsonResponse logout(long userId) throws ServiceException {
        logger.info("invalidating the session for UserId:"+ userId);
        JsonResponse response = new JsonResponse();
        SessionQueryImpl query = new SessionQueryImpl();
        query.filterByUserId(userId);
        try {
            genericRepository.deleteSingle(query.getQuery());
            response.setMessage(Constants.SUCCESS);
            response.setHttpStatus(HttpStatus.OK.toString());
        } catch (PersistanceException e) {
            response.setMessage(Constants.FAIlED);
            response.setHttpStatus(HttpStatus.OK.toString());
            throw new ServiceException(MESSAGE, e);
        }
        return response;

    }

    private String generateToken(String id, long userid) {
        Calendar calendar = new GregorianCalendar();
        String userId = String.valueOf(userid);
        String time = String.valueOf(calendar.getTimeInMillis());
        String sessionId = id.substring(START_INDEX, END_INDEX);
        String token = userId + time + sessionId;
        SessionImpl session = new SessionImpl(userid, id, token);
        genericRepository.save(session);
        return token;
    }
}
