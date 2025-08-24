package dev.jsojka.myecom_product_service.mapper;

import dev.jsojka.myecom_product_service.dto.category.CategoryDto;
import dev.jsojka.myecom_product_service.dto.category.CreateCategoryRequestDto;
import dev.jsojka.myecom_product_service.model.CategoryEntity;

public interface CategoryMapper {
    CategoryEntity createCategoryRequestDtoToCategoryEntity(CreateCategoryRequestDto requestDto);

    CategoryDto categoryEntityToCategoryDto(CategoryEntity categoryEntity);
}
