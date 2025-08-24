package dev.jsojka.myecom_product_service.service.impl;

import dev.jsojka.myecom_product_service.dto.product.CreateProductRequestDto;
import dev.jsojka.myecom_product_service.dto.product.ProductDto;
import dev.jsojka.myecom_product_service.dto.product.UpdateProductRequestDto;
import dev.jsojka.myecom_product_service.exception.CategoryNotFoundException;
import dev.jsojka.myecom_product_service.exception.ProductNotFoundException;
import dev.jsojka.myecom_product_service.mapper.ProductMapper;
import dev.jsojka.myecom_product_service.repository.CategoryRepository;
import dev.jsojka.myecom_product_service.repository.ProductRepository;
import dev.jsojka.myecom_product_service.repository.jpa.CategoryRepositoryJpa;
import dev.jsojka.myecom_product_service.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.productMapper = productMapper;
    }

    @Override
    @Transactional
    public ProductDto save(CreateProductRequestDto productDto) {
        ProductDto productToSave = productMapper.createProductRequestDtoToProductDto(productDto);
        return productRepository.save(productToSave);
    }

    @Override
    public ProductDto findById(UUID productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("Product with id: " + productId + " not found."));
    }

    @Override
    @Transactional
    public void deleteById(UUID productId) {
        productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("Product with id: " + productId + " not found."));

        productRepository.deleteById(productId);
    }

    @Override
    @Transactional
    public void updateById(UUID productId, UpdateProductRequestDto requestDto) {
        productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("Product with id: " + productId + " not found."));

        productRepository.updateById(requestDto, productId);
    }
}
