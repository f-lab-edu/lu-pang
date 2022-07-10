package com.lab.lupang.payments.pay.repository;

import com.lab.lupang.payments.domain.PayDTO;
import com.lab.lupang.payments.dummy.PayTestComponent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
/*
* 외부통신용클래스
* 통신프로토콜: https
* Data: Json
* */
public class PayRepository {

    private final PayTestComponent payTestComponent;

    public String usePay(PayDTO payDto) {
        // 성공
//        return payTestComponent.useCard_success(payDto);
        // 실패
         return payTestComponent.useCard_fail(payDto);
    }
}
