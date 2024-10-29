package com.sergosoft.spacecatsmarket.dto.product.category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import lombok.extern.jackson.Jacksonized;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@Jacksonized
public class CategoryRequestDto {

    /**
     * Title of the product category.
     * Must be not null and not blank.
     */
    @NotBlank(message = "Title is mandatory.")
    String title;

    /**
     * Id of parent category of the current category.
     * Must be a positive number.
     * Can be null if this category is root.
     */
    @Positive(message = "Id of parent category must be a positive number.")
    Integer parentCategoryId;
}
