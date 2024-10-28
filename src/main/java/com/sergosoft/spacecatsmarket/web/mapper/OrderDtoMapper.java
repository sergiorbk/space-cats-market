package com.sergosoft.spacecatsmarket.web.mapper;

import com.sergosoft.spacecatsmarket.common.ProductType;
import com.sergosoft.spacecatsmarket.domain.order.Order;
import com.sergosoft.spacecatsmarket.domain.order.OrderContext;
import com.sergosoft.spacecatsmarket.domain.order.OrderEntry;
import com.sergosoft.spacecatsmarket.dto.order.OrderEntryDto;
import com.sergosoft.spacecatsmarket.dto.order.PlaceOrderRequestDto;
import com.sergosoft.spacecatsmarket.dto.order.PlaceOrderResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderDtoMapper {


    @Mapping(target = "cartId", source = "cartId")
    @Mapping(target = "totalPrice", source = "orderDto.totalPrice")
    @Mapping(target = "customerReference", source = "customerReference")
    @Mapping(target = "entries", source = "orderDto.entries")
    OrderContext toOrderContext(String cartId, String customerReference, PlaceOrderRequestDto orderDto);

    @Mapping(target = "productType", source = "productType")
    @Mapping(target = "amount", source = "quantity")
    OrderEntry toOrderEntry(OrderEntryDto orderEntryDto);

    default ProductType toProductType(String productType) {
        return ProductType.fromDisplayName(productType);
    }

    @Mapping(target = "orderId", source = "id")
    @Mapping(target = "transactionId", source = "transactionId")
    PlaceOrderResponseDto toPlaceOrderResponseDto(Order order);
}
