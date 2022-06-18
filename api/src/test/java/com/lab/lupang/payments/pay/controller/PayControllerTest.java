package com.lab.lupang.payments.pay.controller;

import com.lab.lupang.payments.pay.service.PayService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = PayController.class)
class PayControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    PayService payService;

    @Test
    public void requestPayment() throws Exception {
        String data = "{\"amount\":\"5000\", \"orderId\":\"id00001\", \"orderName\":\"탁상시계\",  \"successUrl\":\"http://127.0.0.1:8080/success_url\", \"failUrl\":\"http://127.0.0.1:8080/fail_url\" }";

        mvc.perform(post("/pg/requestPay")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(data))
                .andExpect(status().isOk())
                .andDo(print());
    }

}