package com.lab.lupang.payments.pay.service;

import com.lab.lupang.payments.domain.PayDTO;
import com.lab.lupang.payments.pay.repository.PayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PayService {
    private final PayRepository payRepository;

    public String requestPay(PayDTO payDTO) {
        // 1. 금액체크
        // 2. 주문번호체크
        return payRepository.usePay(payDTO);
    }
}
