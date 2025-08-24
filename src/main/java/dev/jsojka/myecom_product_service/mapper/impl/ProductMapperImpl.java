package dev.jsojka.myecom_product_service.mapper.impl;

import dev.jsojka.myecom_product_service.dto.category.CategoryDto;
import dev.jsojka.myecom_product_service.dto.product.CreateProductRequestDto;
import dev.jsojka.myecom_product_service.dto.product.ProductDto;
import dev.jsojka.myecom_product_service.dto.product.UpdateProductRequestDto;
import dev.jsojka.myecom_product_service.mapper.CategoryMapper;
import dev.jsojka.myecom_product_service.mapper.ProductMapper;
import dev.jsojka.myecom_product_service.model.CategoryEntity;
import dev.jsojka.myecom_product_service.model.ProductEntity;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ProductMapperImpl implements ProductMapper {

    private final CategoryMapper categoryMapper; // should have used Class CategoryDto ... :)

    public ProductMapperImpl(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    @Override
    public ProductEntity productDtoToProductEntity(ProductDto productDto, CategoryEntity category) {
        return ProductEntity.builder()
                .productId(productDto.productId())
                .productTitle(productDto.productTitle())
                .imageUrl(productDto.imageUrl())
                .priceUnit(productDto.priceUnit())
                .quantity(productDto.quantity())
                .category(category)
                .build();
    }

    @Override
    public ProductDto productEntityToProductDto(ProductEntity productEntity) {
        return ProductDto.builder()
                .productId(productEntity.getProductId())
                .productTitle(productEntity.getProductTitle())
                .imageUrl(productEntity.getImageUrl())
                .priceUnit(productEntity.getPriceUnit())
                .quantity(productEntity.getQuantity())
                .createdAt(productEntity.getCreatedAt())
                .updatedAt(productEntity.getUpdatedAt())
                .category(categoryMapper.categoryEntityToCategoryDto(productEntity.getCategory()))
                .build();
    }

    @Override
    public ProductDto createProductRequestDtoToProductDto(CreateProductRequestDto requestDto) {
        return ProductDto.builder()
                .productId(UUID.randomUUID()) // I'm not sure whether it should be here
                .productTitle(requestDto.productTitle())
                .imageUrl(requestDto.imageUrl())
                .priceUnit(requestDto.priceUnit())
                .quantity(requestDto.quantity())
                .category(CategoryDto.builder()
                        .categoryId(requestDto.categoryId())
                        .build())
                .build();
    }

    @Override
    public ProductEntity updateProductRequestDtoAndProductIdToProductEntity(UpdateProductRequestDto requestDto,
                                                                            UUID productId, CategoryEntity category) {
        return ProductEntity.builder()
                .productId(productId)
                .productTitle(requestDto.productTitle())
                .imageUrl(requestDto.imageUrl())
                .priceUnit(requestDto.priceUnit())
                .quantity(requestDto.quantity())
                .category(category)
                .build();
    }

}
