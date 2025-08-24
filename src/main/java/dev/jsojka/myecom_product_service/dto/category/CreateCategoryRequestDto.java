package dev.jsojka.myecom_product_service.dto.category;

import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

/**
 * DTO for {@link dev.jsojka.myecom_product_service.model.CategoryEntity}
 */
public record CreateCategoryRequestDto(@NotBlank String categoryTitle) implements Serializable {
}