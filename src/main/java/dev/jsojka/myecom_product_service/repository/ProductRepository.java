package dev.jsojka.myecom_product_service.repository;

import dev.jsojka.myecom_product_service.dto.ProductDto;

public interface ProductRepository {
    ProductDto save(ProductDto productDto);
}
