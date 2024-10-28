package com.sergosoft.spacecatsmarket.web;

import com.sergosoft.spacecatsmarket.domain.order.OrderContext;
import com.sergosoft.spacecatsmarket.dto.order.PlaceOrderRequestDto;
import com.sergosoft.spacecatsmarket.dto.order.PlaceOrderResponseDto;
import com.sergosoft.spacecatsmarket.service.OrderService;
import com.sergosoft.spacecatsmarket.web.mapper.OrderDtoMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@Validated
@RequestMapping("/api/v1/{customerReference}/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final OrderDtoMapper orderDtoMapper;

    @PostMapping("/{cartId}")
    public ResponseEntity<PlaceOrderResponseDto> placeOrder(
        @PathVariable("customerReference") String customerReference,
        @PathVariable("cartId") String cartId,
        @RequestBody @Valid PlaceOrderRequestDto placeOrderDto) {

        log.info("Placing the order for cart with id : {}", cartId);
        OrderContext context = orderDtoMapper.toOrderContext(cartId, customerReference, placeOrderDto);
        return ResponseEntity.ok(orderDtoMapper.toPlaceOrderResponseDto(orderService.placeOrder(context)));
    }
}

