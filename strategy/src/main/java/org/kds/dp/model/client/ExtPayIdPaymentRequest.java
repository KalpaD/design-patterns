package org.kds.dp.model.client;

import java.util.StringJoiner;

public class ExtPayIdPaymentRequest {

    private String payId;
    private String description;

    public ExtPayIdPaymentRequest(String payId, String description) {
        this.payId = payId;
        this.description = description;
    }

    public String getPayId() {
        return payId;
    }

    public void setPayId(String payId) {
        this.payId = payId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ExtPayIdPaymentRequest.class.getSimpleName() + "[", "]")
                .add("payId='" + payId + "'")
                .add("description='" + description + "'")
                .toString();
    }
}
