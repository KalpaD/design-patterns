package org.kds.dp.service;

import org.kds.dp.exception.UninterestedPaymentTypeException;
import org.kds.dp.model.Payment;
import org.kds.dp.model.PaymentResponse;
import org.kds.dp.model.PaymentType;
import org.springframework.stereotype.Service;

@Service
public class NoOpPaymentProcessor implements PaymentProcessingService {

    @Override
    public PaymentResponse process(Payment payment) {
        throw new UninterestedPaymentTypeException("un supported payment type");
    }

    @Override
    public PaymentType getSupportedType() {
        return PaymentType.NOT_IMPLEMENTED;
    }
}
