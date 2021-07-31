package org.kds.dp.service;

import org.kds.dp.client.ExternalPaymentClient;
import org.kds.dp.model.Payment;
import org.kds.dp.model.PaymentResponse;
import org.kds.dp.model.PaymentType;
import org.kds.dp.model.client.ExtPayIdPaymentRequest;
import org.kds.dp.model.client.ExtPayIdPaymentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayIdPaymentProcessor implements PaymentProcessingService {

    private final ExternalPaymentClient externalPaymentClient;

    @Autowired
    public PayIdPaymentProcessor(ExternalPaymentClient externalPaymentClient) {
        this.externalPaymentClient = externalPaymentClient;
    }

    @Override
    public PaymentResponse process(Payment payment) {
        var extPayIdReq = new ExtPayIdPaymentRequest(payment.getPayId(), payment.getDescription());
        var extPayIdPaymentResponse = externalPaymentClient.executePayIdPaymentEndpoint(extPayIdReq);
        return new PaymentResponse(extPayIdPaymentResponse.getPayIdReference());
    }

    @Override
    public PaymentType getSupportedType() {
        return PaymentType.PAY_ID;
    }
}
