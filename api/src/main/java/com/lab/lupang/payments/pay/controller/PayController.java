package com.lab.lupang.payments.pay.controller;
import com.lab.lupang.payments.domain.PayDTO;
import com.lab.lupang.payments.pay.service.PayService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PayController {

    private final PayService payService;


    // 결제요청 API
    @PostMapping(path = "/pg/requestPay")
    public String requestPayment(@RequestBody PayDTO payDTO){
        return payService.requestPay(payDTO);
    }

}
