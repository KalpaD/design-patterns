package org.kds.dp.model.client;

public class ExtPayIdPaymentResponse {

    private String payIdReference;

    public ExtPayIdPaymentResponse(String payIdReference) {
        this.payIdReference = payIdReference;
    }

    public String getPayIdReference() {
        return payIdReference;
    }

    public void setPayIdReference(String payIdReference) {
        this.payIdReference = payIdReference;
    }
}
