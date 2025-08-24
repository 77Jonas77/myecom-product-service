package dev.jsojka.myecom_product_service.mapper;

import dev.jsojka.myecom_product_service.dto.CreateProductRequestDto;
import dev.jsojka.myecom_product_service.dto.ProductDto;
import dev.jsojka.myecom_product_service.dto.UpdateProductRequestDto;
import dev.jsojka.myecom_product_service.model.ProductEntity;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductEntity productDtoToProductEntity(ProductDto productDto) {
        return ProductEntity.builder()
                .productId(productDto.productId())
                .productTitle(productDto.productTitle())
                .imageUrl(productDto.imageUrl())
                .priceUnit(productDto.priceUnit())
                .quantity(productDto.quantity())
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
                .build();
    }

    @Override
    public ProductEntity updateProductRequestDtoAndProductIdToProductEntity(UpdateProductRequestDto requestDto, UUID productId) {
        return ProductEntity.builder()
                .productId(productId)
                .productTitle(requestDto.productTitle())
                .imageUrl(requestDto.imageUrl())
                .priceUnit(requestDto.priceUnit())
                .quantity(requestDto.quantity())
                .build();
    }

}
