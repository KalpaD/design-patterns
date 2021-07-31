package org.kds.dp.model;

public enum PaymentType {

    BSB_ACC_NUM("bsbAccNum"),
    PAY_ID("payId"),
    NOT_IMPLEMENTED("notImplemented");

    private final String paymentTypeDesc;

    PaymentType(String paymentTypeDesc) {
        this.paymentTypeDesc = paymentTypeDesc;
    }

    public String getPaymentTypeDesc() {
        return paymentTypeDesc;
    }
}
