package com.sergosoft.spacecatsmarket.domain.order;

import com.sergosoft.spacecatsmarket.common.ProductType;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class OrderEntry {

    ProductType productType;
    int amount;

}
