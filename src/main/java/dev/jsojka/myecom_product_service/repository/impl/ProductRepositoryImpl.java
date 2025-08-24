package dev.jsojka.myecom_product_service.repository.impl;

import dev.jsojka.myecom_product_service.dto.product.ProductDto;
import dev.jsojka.myecom_product_service.dto.product.UpdateProductRequestDto;
import dev.jsojka.myecom_product_service.exception.CategoryNotFoundException;
import dev.jsojka.myecom_product_service.exception.ProductNotFoundException;
import dev.jsojka.myecom_product_service.mapper.ProductMapper;
import dev.jsojka.myecom_product_service.model.CategoryEntity;
import dev.jsojka.myecom_product_service.model.ProductEntity;
import dev.jsojka.myecom_product_service.repository.ProductRepository;
import dev.jsojka.myecom_product_service.repository.jpa.CategoryRepositoryJpa;
import dev.jsojka.myecom_product_service.repository.jpa.ProductRepositoryJpa;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final ProductRepositoryJpa productRepositoryJpa;
    private final CategoryRepositoryJpa categoryRepositoryJpa;
    private final ProductMapper productMapper;

    public ProductRepositoryImpl(ProductRepositoryJpa productRepositoryJpa, CategoryRepositoryJpa categoryRepositoryJpa, ProductMapper productMapper) {
        this.productRepositoryJpa = productRepositoryJpa;
        this.categoryRepositoryJpa = categoryRepositoryJpa;
        this.productMapper = productMapper;
    }

    @Override
    public ProductDto save(ProductDto productDto) {
        CategoryEntity categoryEntity = categoryRepositoryJpa.findById(productDto.category().categoryId())
                .orElseThrow(() -> new CategoryNotFoundException("Category with id: " +
                        productDto.category().categoryId() + " not found"));

        ProductEntity productEntity = productMapper.productDtoToProductEntity(productDto, categoryEntity);
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
        CategoryEntity category = categoryRepositoryJpa.findById(requestDto.categoryId())
                .orElseThrow(() -> new CategoryNotFoundException("Category with id: " +
                        requestDto.categoryId() + " not found"));
        productRepositoryJpa.updateByProductId(productId, requestDto.productTitle(), requestDto.quantity(),
                requestDto.imageUrl(), requestDto.priceUnit(), Instant.now(), category); // I think it might be bad practise
    }

}
