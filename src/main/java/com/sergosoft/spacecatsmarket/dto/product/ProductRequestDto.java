package com.sergosoft.spacecatsmarket.dto.product;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import org.hibernate.validator.constraints.URL;

import lombok.extern.jackson.Jacksonized;
import lombok.Builder;
import lombok.Value;

import com.sergosoft.spacecatsmarket.domain.product.ProductCategory;

@Value
@Builder
@Jacksonized
public class ProductRequestDto {

    /**
     * Unique identifier for the product.
     */
    Long id;

    /**
     * List of categories related to the product.
     * Must contain at least one category.
     */
    @NotNull(message = "Related categories list is mandatory.")
    @NotEmpty(message = "Related categories list must contain at least 1 category.")
    List<ProductCategory> relatedCategories;

    /**
     * Title of the product.
     * Must be a non-blank string.
     */
    @NotBlank(message = "Title is mandatory.")
    String title;

    /**
     * Description of the product.
     * Must be a non-blank string.
     */
    @NotBlank(message = "Description is mandatory.")
    String description;

    /**
     * List of URLs pointing to images of the product.
     * Each URL must be valid, and the list must contain at least one URL.
     */
    @NotNull(message = "Images list is mandatory.")
    @NotEmpty(message = "Images URLs list must contain at least 1 image URL.")
    List<@URL(message = "Invalid URL for the image.") String> imagesUrls;
}
