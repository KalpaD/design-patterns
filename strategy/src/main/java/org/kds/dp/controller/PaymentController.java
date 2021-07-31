package org.kds.dp.controller;

import org.kds.dp.exception.UninterestedPaymentTypeException;
import org.kds.dp.extractor.PaymentTypeExtractor;
import org.kds.dp.factory.PaymentProcessorFactory;
import org.kds.dp.model.Payment;
import org.kds.dp.model.PaymentRequest;
import org.kds.dp.model.PaymentResponse;
import org.kds.dp.model.PaymentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/payment")
public class PaymentController {

    private final Logger logger = LoggerFactory.getLogger(PaymentController.class);
    private final PaymentProcessorFactory factory;

    @Autowired
    public PaymentController(PaymentProcessorFactory factory) {
        this.factory = factory;
    }

    @PostMapping
    public ResponseEntity<PaymentResponse> payment(@RequestBody PaymentRequest request) {
        try {
            var payment = new Payment(request.getAmount(), request.getDescription(), request.getPaymentType());
            var paymentResponse = factory
                    .findPaymentProcessor(PaymentTypeExtractor.fromPaymentRequest(request))
                    .process(payment);
            return ResponseEntity.ok(paymentResponse);
        } catch (UninterestedPaymentTypeException exception) {
            logger.info("We are not interested in this payment type");
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }
}
