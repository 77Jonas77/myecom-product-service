package dev.jsojka.myecom_product_service.repository;

import dev.jsojka.myecom_product_service.dto.product.ProductDto;
import dev.jsojka.myecom_product_service.dto.product.UpdateProductRequestDto;

import java.util.Optional;
import java.util.UUID;

public interface ProductRepository {
    ProductDto save(ProductDto productDto);

    Optional<ProductDto> findById(UUID productId);

    void deleteById(UUID productId);

    void updateById(UpdateProductRequestDto requestDto, UUID productId);

}
