package dev.jsojka.myecom_product_service.mapper;

import dev.jsojka.myecom_product_service.dto.CreateProductRequestDto;
import dev.jsojka.myecom_product_service.dto.ProductDto;
import dev.jsojka.myecom_product_service.dto.UpdateProductRequestDto;
import dev.jsojka.myecom_product_service.model.ProductEntity;

import java.util.UUID;

public interface ProductMapper {
    ProductEntity productDtoToProductEntity(ProductDto productDto);

    ProductDto productEntityToProductDto(ProductEntity productEntity);

    ProductDto createProductRequestDtoToProductDto(CreateProductRequestDto requestDto);

    ProductEntity updateProductRequestDtoAndProductIdToProductEntity(UpdateProductRequestDto requestDto, UUID productId);
}
