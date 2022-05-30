package com.lab.lupang.payments.pay.controller;

import com.lab.lupang.payments.pay.service.RequestPayService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = RequestPayController.class)
public class RequestPayControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    RequestPayService requestPayService;

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
