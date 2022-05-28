package com.lab.lupang.payments.pay.repository;

import java.util.HashMap;

public interface RequestPayRepository {
    public String usePay(HashMap<String, String> params);
}
