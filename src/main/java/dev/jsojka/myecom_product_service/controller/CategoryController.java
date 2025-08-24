package dev.jsojka.myecom_product_service.controller;

import dev.jsojka.myecom_product_service.dto.ApiResponse;
import dev.jsojka.myecom_product_service.dto.category.CategoryDto;
import dev.jsojka.myecom_product_service.dto.category.CreateCategoryRequestDto;
import dev.jsojka.myecom_product_service.service.CategoryService;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<CategoryDto> save(@RequestBody @Valid CreateCategoryRequestDto requestDto) {
        CategoryDto response = categoryService.save(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> findById(@PathVariable Integer categoryId) {
        CategoryDto response = categoryService.findById(categoryId);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<ApiResponse> deleteById(@PathVariable Integer categoryId) {
        categoryService.deleteById(categoryId);
        return ResponseEntity.ok(new ApiResponse("Category with id: " + categoryId + " deleted successfully."));
    }

    @GetMapping
    public ResponseEntity<List<CategoryDto>> findAll() {
        List<CategoryDto> response = categoryService.findAll();
        return ResponseEntity.ok(response);
    }
}
