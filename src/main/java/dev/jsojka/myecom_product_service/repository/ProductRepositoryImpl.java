package dev.jsojka.myecom_product_service.repository;

import dev.jsojka.myecom_product_service.dto.ProductDto;
import dev.jsojka.myecom_product_service.mapper.ProductMapper;
import dev.jsojka.myecom_product_service.model.ProductEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

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
        return productEntity.map(productMapper::productEntityToProductDto).or(() -> Optional.of(ProductDto.builder().build()));
    }

    @Override
    public void deleteById(UUID productId) {
        productRepositoryJpa.deleteById(productId);
    }

}
