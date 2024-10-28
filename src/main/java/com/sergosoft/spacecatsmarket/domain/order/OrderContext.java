package com.sergosoft.spacecatsmarket.domain.order;

import java.util.List;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class OrderContext {

    String cartId;
    String customerReference;
    List<OrderEntry> entries;
    Double totalPrice;
}
