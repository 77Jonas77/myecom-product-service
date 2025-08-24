package dev.jsojka.myecom_product_service.service;

import dev.jsojka.myecom_product_service.dto.CreateProductRequestDto;
import dev.jsojka.myecom_product_service.dto.ProductDto;

public interface ProductService {
    ProductDto save(CreateProductRequestDto productDto);
}
