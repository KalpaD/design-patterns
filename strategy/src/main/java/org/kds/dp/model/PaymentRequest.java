package org.kds.dp.model;

import java.math.BigDecimal;

public class PaymentRequest {

    private String paymentType;
    private BigDecimal amount;
    private String description;

    public PaymentRequest(String paymentType, BigDecimal amount, String description) {
        this.paymentType = paymentType;
        this.amount = amount;
        this.description = description;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
