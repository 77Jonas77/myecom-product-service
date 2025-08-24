package dev.jsojka.myecom_product_service.service;

import dev.jsojka.myecom_product_service.dto.category.CategoryDto;
import dev.jsojka.myecom_product_service.dto.category.CreateCategoryRequestDto;
import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    CategoryDto save(CreateCategoryRequestDto requestDto);

    CategoryDto findById(Integer categoryId);

    void deleteById(Integer categoryId);

    List<CategoryDto> findAll();

}
