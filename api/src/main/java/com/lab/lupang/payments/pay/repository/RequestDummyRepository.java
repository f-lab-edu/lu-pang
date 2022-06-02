package com.lab.lupang.payments.pay.repository;

import com.lab.lupang.payments.domain.PayDTO;
import com.lab.lupang.payments.dummy.PayTestComponent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class RequestDummyRepository implements RequestPayRepository{
    private final PayTestComponent payTestComponent;

    @Override
    public String usePay(PayDTO payDto) {
        return payTestComponent.useCard(payDto);
    }
}
