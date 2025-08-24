package dev.jsojka.myecom_product_service.repository.impl;

import dev.jsojka.myecom_product_service.dto.product.ProductDto;
import dev.jsojka.myecom_product_service.dto.product.UpdateProductRequestDto;
import dev.jsojka.myecom_product_service.mapper.ProductMapper;
import dev.jsojka.myecom_product_service.model.ProductEntity;
import dev.jsojka.myecom_product_service.repository.ProductRepository;
import dev.jsojka.myecom_product_service.repository.jpa.ProductRepositoryJpa;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final ProductRepositoryJpa productRepositoryJpa;
    private final ProductMapper productMapper;

    public ProductRepositoryImpl(ProductRepositoryJpa productRepositoryJpa, ProductMapper productMapper) {
        this.productRepositoryJpa = productRepositoryJpa;
        this.productMapper = productMapper;
    }

    @Override
    public ProductDto save(ProductDto productDto) {
        ProductEntity productEntity = productMapper.productDtoToProductEntity(productDto);
        ProductEntity savedProductEntity = productRepositoryJpa.save(productEntity);
        return productMapper.productEntityToProductDto(savedProductEntity);
    }

    @Override
    public Optional<ProductDto> findById(UUID productId) {
        Optional<ProductEntity> productEntity = productRepositoryJpa.findById(productId);
        return productEntity.map(productMapper::productEntityToProductDto).or(Optional::empty);
    }

    @Override
    public void deleteById(UUID productId) {
        productRepositoryJpa.deleteById(productId);
    }

    @Override
    public void updateById(UpdateProductRequestDto requestDto, UUID productId) {
        productRepositoryJpa.updateByProductId(productId, requestDto.productTitle(), requestDto.quantity(),
                requestDto.imageUrl(), requestDto.priceUnit(), Instant.now());
    }

}
