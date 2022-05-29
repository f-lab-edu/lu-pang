package com.lab.lupang.payments.pay.service;

import com.lab.lupang.payments.pay.repository.RequestDummyRepository;
import com.lab.lupang.payments.pay.repository.RequestPayRepository;
import org.springframework.stereotype.Service;
import java.util.HashMap;

@Service
public class RequestPayService {
    private final RequestPayRepository requestPayRepository;

    public RequestPayService(RequestDummyRepository requestDummyRepository) {
        this.requestPayRepository = requestDummyRepository;
    }

    public String requestPay(HashMap<String, String> params) {
        return requestPayRepository.usePay(params);
    }
}
