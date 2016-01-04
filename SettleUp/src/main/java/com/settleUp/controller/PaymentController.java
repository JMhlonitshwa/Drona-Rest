package com.settleUp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.settleUp.requestResponse.PaymentResponse;

@Controller
public class PaymentController extends BaseController {

	public @ResponseBody PaymentResponse getPayment(@RequestParam("groupdId") Long groupId){
		
	}
}
