package org.kds.dp.service;

import org.kds.dp.model.Payment;
import org.kds.dp.model.PaymentResponse;
import org.kds.dp.model.PaymentType;

public interface PaymentProcessingService {

    PaymentResponse process(Payment payment);

    PaymentType getSupportedType();
}
