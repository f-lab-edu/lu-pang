package com.lab.lupang.payments.domain;

public class PayDTO {
    private int amount;
    private String orderId;
    private String orderName;
    private String successUrl;
    private String failUrl;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getSuccessUrl() {
        return successUrl;
    }

    public void setSuccessUrl(String successUrl) {
        this.successUrl = successUrl;
    }

    public String getFailUrl() {
        return failUrl;
    }

    public void setFailUrl(String failUrl) {
        this.failUrl = failUrl;
    }

    @Override
    public String toString() {
        return "PayDTO{" +
                "amount=" + amount +
                ", orderId='" + orderId + '\'' +
                ", orderName='" + orderName + '\'' +
                ", successUrl='" + successUrl + '\'' +
                ", failUrl='" + failUrl + '\'' +
                '}';
    }
}
