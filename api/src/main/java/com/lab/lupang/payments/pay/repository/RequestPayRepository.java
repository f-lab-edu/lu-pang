package com.lab.lupang.payments.pay.repository;

import com.lab.lupang.payments.domain.PayDTO;

public interface RequestPayRepository {
    public String usePay(PayDTO payDto);
}
