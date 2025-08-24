package dev.jsojka.myecom_product_service.service.impl;

import dev.jsojka.myecom_product_service.dto.category.CategoryDto;
import dev.jsojka.myecom_product_service.dto.category.CreateCategoryRequestDto;
import dev.jsojka.myecom_product_service.exception.CategoryNotFoundException;
import dev.jsojka.myecom_product_service.repository.CategoryRepository;
import dev.jsojka.myecom_product_service.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryDto save(CreateCategoryRequestDto requestDto) {
        return categoryRepository.save(requestDto);
    }

    @Override
    public CategoryDto findById(Integer categoryId) {
        return categoryRepository.findById(categoryId)
                .orElseThrow(() -> new CategoryNotFoundException("Category with id: " + categoryId + " not found."));
    }
}
