package com.drona.controller.user;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.drona.common.Constants;
import com.drona.common.json.JsonResponse;
import com.drona.controller.BaseController;

/**
 * controller for user.
 * 
 * @author vinayak.s.mumbai@gmail.com
 *
 */
@Controller
public class UserController extends BaseController {
	private static final Logger logger = Logger.getLogger(UserController.class);
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public @ResponseBody JsonResponse getUserCollection(
			@RequestBody UserJsonRequest request,  @RequestParam(value = "orgId", required=false) Long orgId) {
		//TODO: validate Request here
		userService.createUsers(request.getUsers(), orgId);
		JsonResponse response = new JsonResponse(HttpStatus.OK.toString(),
				Constants.CREATED);
		return response;

	}
}
