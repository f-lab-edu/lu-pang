package com.lab.lupang.payments.pay.repository;

import com.lab.lupang.payments.dummy.PayTestComponent;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class RequestDummyRepository implements RequestPayRepository{
    private final PayTestComponent payTestComponent;

    public RequestDummyRepository(PayTestComponent payTestComponent) {
        this.payTestComponent = payTestComponent;
    }

    @Override
    public String usePay(HashMap<String, String> params) {
        return payTestComponent.useCard(params);
    }
}
