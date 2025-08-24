package dev.jsojka.myecom_product_service.mapper;


import dev.jsojka.myecom_product_service.dto.category.CategoryDto;
import dev.jsojka.myecom_product_service.dto.product.ProductDto;
import dev.jsojka.myecom_product_service.dto.product.CreateProductRequestDto;
import dev.jsojka.myecom_product_service.dto.product.UpdateProductRequestDto;
import dev.jsojka.myecom_product_service.model.CategoryEntity;
import dev.jsojka.myecom_product_service.model.ProductEntity;

import java.util.UUID;

public interface ProductMapper {
    ProductEntity productDtoToProductEntity(ProductDto productDto, CategoryEntity category);

    ProductDto productEntityToProductDto(ProductEntity productEntity);

    ProductDto createProductRequestDtoToProductDto(CreateProductRequestDto requestDto);

    ProductEntity updateProductRequestDtoAndProductIdToProductEntity(UpdateProductRequestDto requestDto,
                                                                     UUID productId, CategoryEntity category);
}
