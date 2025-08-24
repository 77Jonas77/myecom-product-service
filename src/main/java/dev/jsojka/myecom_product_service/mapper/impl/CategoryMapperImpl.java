package dev.jsojka.myecom_product_service.mapper.impl;

import dev.jsojka.myecom_product_service.dto.category.CategoryDto;
import dev.jsojka.myecom_product_service.dto.category.CreateCategoryRequestDto;
import dev.jsojka.myecom_product_service.mapper.CategoryMapper;
import dev.jsojka.myecom_product_service.model.CategoryEntity;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapperImpl implements CategoryMapper {
    @Override
    public CategoryEntity createCategoryRequestDtoToCategoryEntity(CreateCategoryRequestDto requestDto) {
        return CategoryEntity.builder()
                .categoryTitle(requestDto.categoryTitle())
                .build();
    }

    @Override
    public CategoryDto categoryEntityToCategoryDto(CategoryEntity categoryEntity) {
        return CategoryDto.builder()
                .categoryId(categoryEntity.getCategoryId())
                .categoryTitle(categoryEntity.getCategoryTitle())
                .createdAt(categoryEntity.getCreatedAt())
                .updatedAt(categoryEntity.getUpdatedAt())
                .build();
    }
}
