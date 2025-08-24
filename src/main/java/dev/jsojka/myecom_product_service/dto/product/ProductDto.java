package dev.jsojka.myecom_product_service.dto.product;

import lombok.Builder;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

/**
 * DTO for {@link dev.jsojka.myecom_product_service.model.ProductEntity}
 */
@Builder
public record ProductDto(UUID productId, String productTitle, String imageUrl, BigDecimal priceUnit, Integer quantity,
                         Instant createdAt, Instant updatedAt) implements Serializable {
}