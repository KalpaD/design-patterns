package org.kds.dp.extractor;

import org.kds.dp.model.PaymentRequest;
import org.kds.dp.model.PaymentType;

import java.util.Arrays;

public class PaymentTypeExtractor {

    public static PaymentType fromPaymentRequest(PaymentRequest request) {

        return Arrays.stream(PaymentType.values())
                .filter(enumVal -> enumVal.getPaymentTypeDesc().equals(request.getPaymentType()))
                .findFirst()
                .orElse(PaymentType.NOT_IMPLEMENTED);
    }
}
