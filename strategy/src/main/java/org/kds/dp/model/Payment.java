package org.kds.dp.model;

import java.math.BigDecimal;

public class Payment {

    private BigDecimal amount;
    private String description;
    private String payId;
    private String bsb;
    private String accNum;

    public Payment(BigDecimal amount, String description, String payId) {
        this.amount = amount;
        this.description = description;
        this.payId = payId;
    }

    public Payment(BigDecimal amount, String description, String bsb, String accNum) {
        this.amount = amount;
        this.description = description;
        this.bsb = bsb;
        this.accNum = accNum;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public String getPayId() {
        return payId;
    }

    public String getBsb() {
        return bsb;
    }

    public String getAccNum() {
        return accNum;
    }
}
