package com.sergosoft.spacecatsmarket.service;

import com.sergosoft.spacecatsmarket.domain.payment.Payment;
import com.sergosoft.spacecatsmarket.domain.payment.PaymentTransaction;

public interface PaymentService {

    PaymentTransaction processPayment(Payment payment);

}
