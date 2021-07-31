package org.kds.dp.factory;

import org.kds.dp.model.PaymentType;
import org.kds.dp.service.PaymentProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class PaymentProcessorFactory {

    private Map<PaymentType, PaymentProcessingService> paymentProcessorMap;

    @Autowired
    public PaymentProcessorFactory(Set<PaymentProcessingService> paymentProcessingServiceSet) {
        paymentProcessorMap = createStrategy(paymentProcessingServiceSet);
    }

    public PaymentProcessingService findPaymentProcessor(PaymentType paymentType) {
        return paymentProcessorMap.get(paymentType);
    }

    private ConcurrentHashMap<PaymentType, PaymentProcessingService> createStrategy(Set<PaymentProcessingService> paymentProcessingServiceSet) {
        var processorMap =  new ConcurrentHashMap<PaymentType, PaymentProcessingService>();
        paymentProcessingServiceSet.forEach(processingService -> processorMap.put(processingService.getSupportedType(), processingService));
        return processorMap;
    }
}
