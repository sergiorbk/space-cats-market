package com.sergosoft.spacecatsmarket.domain.product;

import java.util.List;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Product {

    Long id;
    List<ProductCategory> relatedCategories;
    String title;
    String description;
    List<String> imagesUrls;
}
