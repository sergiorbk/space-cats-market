package com.sergosoft.spacecatsmarket.service.impl;

import com.sergosoft.spacecatsmarket.domain.order.Order;
import com.sergosoft.spacecatsmarket.domain.order.OrderContext;
import com.sergosoft.spacecatsmarket.domain.order.OrderEntry;
import com.sergosoft.spacecatsmarket.domain.payment.PaymentTransaction;
import com.sergosoft.spacecatsmarket.service.OrderService;
import com.sergosoft.spacecatsmarket.service.PaymentService;
import com.sergosoft.spacecatsmarket.service.exception.PaymentTransactionFailed;
import com.sergosoft.spacecatsmarket.service.mapper.PaymentMapper;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.sergosoft.spacecatsmarket.common.PaymentStatus.FAILURE;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final PaymentService paymentService;
    private final PaymentMapper paymentMapper;

    @Override
    public Order placeOrder(OrderContext orderContext) {
        log.info("Placing order for cart with id: {}", orderContext.getCartId());
        PaymentTransaction paymentTransaction = paymentService.processPayment(paymentMapper.toPayment(orderContext));
        if (FAILURE.equals(paymentTransaction.getStatus())) {
            throw new PaymentTransactionFailed(paymentTransaction.getId(), orderContext.getCartId());
        }
        // TODO add mock for order service
        return createOrderMock(orderContext.getCartId(),
            orderContext.getEntries(),
            orderContext.getTotalPrice(),
            orderContext.getCustomerReference(),
            paymentTransaction.getId());
    }

    private Order createOrderMock(String cartId, List<OrderEntry> entries, Double totalPrice, String consumerReference, UUID transactionId) {
        return Order.builder()
            .id(UUID.randomUUID().toString())
            .transactionId(transactionId)
            .cartId(cartId)
            .entries(entries)
            .totalPrice(totalPrice)
            .consumerReference(consumerReference)
            .build();
    }
}