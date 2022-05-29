package com.lab.lupang.payments.pay.service;

import com.google.gson.Gson;
import com.lab.lupang.payments.dummy.PayTestComponent;
import com.lab.lupang.payments.pay.repository.RequestDummyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class RequestPayServiceTest {

    RequestDummyRepository requestDummyRepository;
    RequestPayService requestPayService;

    @BeforeEach
    void setUp() {
        requestDummyRepository = new RequestDummyRepository(new PayTestComponent());
        requestPayService      = new RequestPayService(requestDummyRepository);
    }

    @Test
    void requestPay() {
        // 1. 결제요청 파라미터설정.
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("amount",     "5000");
        param.put("orderId",    "id00001");
        param.put("orderName",  "탁상시계");
        param.put("successUrl", "http://127.0.0.1:8080/success_url");
        param.put("failUrl",    "http://127.0.0.1:8080/fail_url");

        // 2. 결제요청처리
        String returnJson = requestPayService.requestPay(param);

        // 3. 결제응답
        Map<String, Object> map = new HashMap<String, Object>();
        Gson gson = new Gson();
        map = (Map<String, Object>) gson.fromJson(returnJson, map.getClass());
        assertThat(map.get("ret_code")).isEqualTo("0000");
    }
}
