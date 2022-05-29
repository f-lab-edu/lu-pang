package com.lab.lupang.payments.pay.controller;

import com.lab.lupang.payments.pay.service.RequestPayService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class RequestPayController {

    private final RequestPayService requestPayService;

    public RequestPayController(RequestPayService requestPayService) {
        this.requestPayService = requestPayService;
    }

    // 결제요청 API
    @PostMapping(path = "/pg/requestPay")
    public String requestPayment(@RequestBody HashMap<String, String> params){
        return requestPayService.requestPay(params);
    }

}
