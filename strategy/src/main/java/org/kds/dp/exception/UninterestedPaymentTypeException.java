package org.kds.dp.exception;

public class UninterestedPaymentTypeException extends RuntimeException {

    public UninterestedPaymentTypeException() {
    }

    public UninterestedPaymentTypeException(String message) {
        super(message);
    }
}
