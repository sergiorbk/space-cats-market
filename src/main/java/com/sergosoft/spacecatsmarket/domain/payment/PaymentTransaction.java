package com.sergosoft.spacecatsmarket.domain.payment;

import com.sergosoft.spacecatsmarket.common.PaymentStatus;
import java.util.UUID;
import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class PaymentTransaction {

    UUID id;
    PaymentStatus status;
    String cartId;
}
