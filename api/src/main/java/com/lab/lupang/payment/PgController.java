package com.lab.lupang.payment;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PgController {

    /*
    * 최초 가맹점 인입 시 호출되는 메서드.
    * */
    @GetMapping("requestPay")
//    @PostMapping("requestPay")
    public String reqPayPop(HttpServletRequest req) {
        // 1. 가맹점에서 넘어온 필수파라미터 체크.
        // 2. 결제창 화면 리턴
        return "requestPay";
    }
}
