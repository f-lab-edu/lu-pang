package com.lab.lupang.payments.pay.repository;

import com.lab.lupang.payments.domain.PayDTO;
import com.lab.lupang.payments.dummy.PayTestComponent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class PayRepository {
    private final PayTestComponent payTestComponent;

    public String usePay(PayDTO payDto) {
        return payTestComponent.useCard(payDto);
    }
}
