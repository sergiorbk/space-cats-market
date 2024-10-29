package com.sergosoft.spacecatsmarket.dto.product;

import java.util.List;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import com.sergosoft.spacecatsmarket.dto.product.category.CategoryEntryDto;

@Value
@Builder
@Jacksonized
public class ProductResponseDto {

    Long id;
    List<CategoryEntryDto> relatedCategoriesIds;
    String title;
    String description;
    List<String> imagesUrls;
}
