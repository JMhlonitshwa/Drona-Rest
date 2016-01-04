package com.settleUp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.settleUp.requestResponse.JsonResponse;
import com.settleUp.requestResponse.PaymentRequest;
import com.settleUp.requestResponse.PaymentResponse;
import com.settleUp.service.PaymentServices;

@Controller
public class PaymentController extends BaseController {

    @Autowired
    private PaymentServices paymentServices;
    @RequestMapping(value = "/payments", method = RequestMethod.GET)
     public @ResponseBody PaymentResponse getPayment(@RequestParam("groupdId") Long groupId){
         paymentServices.getPayments(groupId);
        return null;
    
     }
    @RequestMapping(value = "/payments", method = RequestMethod.POST)
    public @ResponseBody JsonResponse createPayment(@RequestBody PaymentRequest request) {
        paymentServices.createPayment(request);
        return new JsonResponse(HttpStatus.OK, "Created sucessfully");


    }
}
