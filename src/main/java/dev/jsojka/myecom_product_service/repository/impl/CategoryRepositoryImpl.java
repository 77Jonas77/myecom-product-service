package dev.jsojka.myecom_product_service.repository.impl;

import dev.jsojka.myecom_product_service.dto.category.CategoryDto;
import dev.jsojka.myecom_product_service.dto.category.CreateCategoryRequestDto;
import dev.jsojka.myecom_product_service.mapper.CategoryMapper;
import dev.jsojka.myecom_product_service.model.CategoryEntity;
import dev.jsojka.myecom_product_service.repository.CategoryRepository;
import dev.jsojka.myecom_product_service.repository.jpa.CategoryRepositoryJpa;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

    private final CategoryRepositoryJpa categoryRepositoryJpa;
    private final CategoryMapper categoryMapper;

    public CategoryRepositoryImpl(CategoryRepositoryJpa categoryRepositoryJpa, CategoryMapper categoryMapper) {
        this.categoryRepositoryJpa = categoryRepositoryJpa;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public CategoryDto save(CreateCategoryRequestDto requestDto) {
        CategoryEntity categoryEntity = categoryMapper.createCategoryRequestDtoToCategoryEntity(requestDto);
        categoryRepositoryJpa.save(categoryEntity);
        return categoryMapper.categoryEntityToCategoryDto(categoryEntity);
    }

    @Override
    public Optional<CategoryDto> findById(Integer categoryId) {
        Optional<CategoryEntity> categoryEntity = categoryRepositoryJpa.findById(categoryId);
        return categoryEntity.map(categoryMapper::categoryEntityToCategoryDto).or(Optional::empty);
    }

    @Override
    public void deleteById(Integer categoryId) {
        categoryRepositoryJpa.deleteById(categoryId);
    }
}
