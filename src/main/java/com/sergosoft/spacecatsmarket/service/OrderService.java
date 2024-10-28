package com.sergosoft.spacecatsmarket.service;

import com.sergosoft.spacecatsmarket.domain.order.Order;
import com.sergosoft.spacecatsmarket.domain.order.OrderContext;

public interface OrderService {

    Order placeOrder(OrderContext orderContext);
}
