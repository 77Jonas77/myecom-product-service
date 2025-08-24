package dev.jsojka.myecom_product_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO for {@link dev.jsojka.myecom_product_service.model.ProductEntity}
 */
public record CreateProductRequestDto(
        @NotBlank String productTitle,
        @NotBlank String imageUrl,
        @NotNull BigDecimal priceUnit,
        @NotNull Integer quantity
) implements Serializable {
}