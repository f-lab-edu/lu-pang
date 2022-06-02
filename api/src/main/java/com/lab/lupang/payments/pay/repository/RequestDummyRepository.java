package com.lab.lupang.payments.pay.repository;

import com.lab.lupang.payments.domain.PayDTO;
import com.lab.lupang.payments.dummy.PayTestComponent;
import org.springframework.stereotype.Repository;

@Repository
public class RequestDummyRepository implements RequestPayRepository{
    private final PayTestComponent payTestComponent;

    public RequestDummyRepository(PayTestComponent payTestComponent) {
        this.payTestComponent = payTestComponent;
    }

    @Override
    public String usePay(PayDTO payDto) {
        return payTestComponent.useCard(payDto);
    }
}
