package dev.jsojka.myecom_product_service.service;

import dev.jsojka.myecom_product_service.dto.product.CreateProductRequestDto;
import dev.jsojka.myecom_product_service.dto.product.ProductDto;
import dev.jsojka.myecom_product_service.dto.product.UpdateProductRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface ProductService {
    ProductDto save(CreateProductRequestDto productDto);

    ProductDto findById(UUID productId);

    void deleteById(UUID productId);

    void updateById(UUID productId, UpdateProductRequestDto requestDto);

    Page<ProductDto> findAll(Pageable pageable);

    Page<ProductDto> findAllByCategoryId(Integer categoryId, Pageable pageable);
}
