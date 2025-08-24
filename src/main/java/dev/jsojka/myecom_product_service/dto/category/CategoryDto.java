package dev.jsojka.myecom_product_service.dto.category;

import lombok.Builder;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link dev.jsojka.myecom_product_service.model.CategoryEntity}
 */
@Builder
public record CategoryDto(Instant createdAt, Instant updatedAt, Integer categoryId,
                          String categoryTitle) implements Serializable {
}