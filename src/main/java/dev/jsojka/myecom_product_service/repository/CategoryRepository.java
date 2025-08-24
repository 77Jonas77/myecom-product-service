package dev.jsojka.myecom_product_service.repository;

import dev.jsojka.myecom_product_service.dto.category.CategoryDto;
import dev.jsojka.myecom_product_service.dto.category.CreateCategoryRequestDto;

import java.util.Optional;

public interface CategoryRepository {
    CategoryDto save(CreateCategoryRequestDto requestDto);

    Optional<CategoryDto> findById(Integer categoryId);

    void deleteById(Integer categoryId);

}
