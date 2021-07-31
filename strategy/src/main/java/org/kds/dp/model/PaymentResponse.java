package org.kds.dp.model;

import java.util.UUID;

public class PaymentResponse {

    private String paymentId;

    public PaymentResponse(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentId() {
        return paymentId;
    }
}
