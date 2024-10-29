package com.sergosoft.spacecatsmarket.domain.product;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ProductCategory {

    Integer id;
    String title;
    ProductCategory parentCategory;
}
