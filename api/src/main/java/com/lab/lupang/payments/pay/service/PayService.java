package com.lab.lupang.payments.pay.service;

import com.lab.lupang.payments.domain.PayDTO;
import com.lab.lupang.payments.pay.repository.RequestDummyRepository;
import com.lab.lupang.payments.pay.repository.RequestPayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.HashMap;

@RequiredArgsConstructor
@Service
public class PayService {
    private final RequestPayRepository requestPayRepository;

    public String requestPay(PayDTO payDTO) {
        return requestPayRepository.usePay(payDTO);
    }
}
