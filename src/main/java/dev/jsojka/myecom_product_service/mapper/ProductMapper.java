package dev.jsojka.myecom_product_service.mapper;

import dev.jsojka.myecom_product_service.dto.CreateProductRequestDto;
import dev.jsojka.myecom_product_service.dto.ProductDto;
import dev.jsojka.myecom_product_service.model.ProductEntity;

public interface ProductMapper {
    ProductEntity productDtoToProductEntity(ProductDto productDto);

    ProductDto productEntityToProductDto(ProductEntity productEntity);

    ProductDto createProductRequestDtoToProductDto(CreateProductRequestDto requestDto);
}
