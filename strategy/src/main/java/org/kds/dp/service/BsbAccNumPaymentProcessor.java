package org.kds.dp.service;

import org.kds.dp.client.ExternalPaymentClient;
import org.kds.dp.model.Payment;
import org.kds.dp.model.PaymentResponse;
import org.kds.dp.model.PaymentType;
import org.kds.dp.model.client.ExtBsbAccNumPaymentResponse;
import org.kds.dp.model.client.ExtbsbAccNumPaymentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BsbAccNumPaymentProcessor implements PaymentProcessingService {

    private final ExternalPaymentClient externalPaymentClient;

    @Autowired
    public BsbAccNumPaymentProcessor(ExternalPaymentClient externalPaymentClient) {
        this.externalPaymentClient = externalPaymentClient;
    }

    @Override
    public PaymentResponse process(Payment payment) {
        var extBsbAccNumPaymentRequestReq = new ExtbsbAccNumPaymentRequest(payment.getBsb(), payment.getAccNum(), payment.getDescription());
        ExtBsbAccNumPaymentResponse extBsbAccNumPaymentResponse = externalPaymentClient.executeBsbAccNumPaymentEndpoint(extBsbAccNumPaymentRequestReq);
        return new PaymentResponse(extBsbAccNumPaymentResponse.getReceiptId());
    }

    @Override
    public PaymentType getSupportedType() {
        return PaymentType.BSB_ACC_NUM;
    }

}
