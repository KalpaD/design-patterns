package org.kds.dp.model.client;

import java.util.StringJoiner;

public class ExtbsbAccNumPaymentRequest {

    private String bsb;
    private String accNum;
    private String description;

    public ExtbsbAccNumPaymentRequest(String bsb, String accNum, String description) {
        this.bsb = bsb;
        this.accNum = accNum;
        this.description = description;
    }

    public String getBsb() {
        return bsb;
    }

    public void setBsb(String bsb) {
        this.bsb = bsb;
    }

    public String getAccNum() {
        return accNum;
    }

    public void setAccNum(String accNum) {
        this.accNum = accNum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ExtbsbAccNumPaymentRequest.class.getSimpleName() + "[", "]")
                .add("bsb='" + bsb + "'")
                .add("accNum='" + accNum + "'")
                .add("description='" + description + "'")
                .toString();
    }
}
