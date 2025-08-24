package dev.jsojka.myecom_product_service.service;

import dev.jsojka.myecom_product_service.dto.CreateProductRequestDto;
import dev.jsojka.myecom_product_service.dto.ProductDto;
import dev.jsojka.myecom_product_service.dto.UpdateProductRequestDto;
import jakarta.validation.Valid;

import java.util.UUID;

public interface ProductService {
    ProductDto save(CreateProductRequestDto productDto);

    ProductDto findById(UUID productId);

    void deleteById(UUID productId);

    void updateById(UUID productId, UpdateProductRequestDto requestDto);
}
