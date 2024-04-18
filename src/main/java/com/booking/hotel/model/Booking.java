package com.booking.hotel.model;

public class Booking {
    enum PAYMENT_STATUS{PAID, PENDING, NOT_PAID}
    String id;
    String customerId;
    PAYMENT_STATUS paymentStatus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public PAYMENT_STATUS getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PAYMENT_STATUS paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
