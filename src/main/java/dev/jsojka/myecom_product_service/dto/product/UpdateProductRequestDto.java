package dev.jsojka.myecom_product_service.dto.product;

import dev.jsojka.myecom_product_service.dto.category.CategoryDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record UpdateProductRequestDto(
        @NotBlank String productTitle,
        @NotBlank String imageUrl,
        @NotNull BigDecimal priceUnit,
        @NotNull Integer quantity,
        @NotNull Integer categoryId
) {
}
