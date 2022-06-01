package com.lab.lupang.payments.domain;

import java.util.Objects;

public class PayVO {
    private String pg_tr_id;    // 1. 거래번호
    private String req_amount;  // 2. 결제금액
    private String ret_code;    // 3. 응답코드
    private String ret_msg;     // 4. 응답메시지

    public String getPg_tr_id() {
        return pg_tr_id;
    }

    public void setPg_tr_id(String pg_tr_id) {
        this.pg_tr_id = pg_tr_id;
    }

    public String getReq_amount() {
        return req_amount;
    }

    public void setReq_amount(String req_amount) {
        this.req_amount = req_amount;
    }

    public String getRet_code() {
        return ret_code;
    }

    public void setRet_code(String ret_code) {
        this.ret_code = ret_code;
    }

    public String getRet_msg() {
        return ret_msg;
    }

    public void setRet_msg(String ret_msg) {
        this.ret_msg = ret_msg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PayVO payVO = (PayVO) o;
        return Objects.equals(pg_tr_id, payVO.pg_tr_id) && Objects.equals(req_amount, payVO.req_amount) && Objects.equals(ret_code, payVO.ret_code) && Objects.equals(ret_msg, payVO.ret_msg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pg_tr_id, req_amount, ret_code, ret_msg);
    }

    @Override
    public String toString() {
        return "PayVO{" +
                "pg_tr_id='" + pg_tr_id + '\'' +
                ", req_amount='" + req_amount + '\'' +
                ", ret_code='" + ret_code + '\'' +
                ", ret_msg='" + ret_msg + '\'' +
                '}';
    }
}
