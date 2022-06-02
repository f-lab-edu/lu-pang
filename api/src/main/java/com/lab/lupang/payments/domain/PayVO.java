package com.lab.lupang.payments.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class PayVO {
    private String pg_tr_id;    // 1. 거래번호
    private int req_amount;     // 2. 결제금액
    private String ret_code;    // 3. 응답코드
    private String ret_msg;     // 4. 응답메시지
}
