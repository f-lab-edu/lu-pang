package com.lab.lupang.payments.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PayDTO {
    private int amount;
    private String orderId;
    private String orderName;
    private String successUrl;
    private String failUrl;
}
