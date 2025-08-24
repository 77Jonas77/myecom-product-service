package dev.jsojka.myecom_product_service.service;

import dev.jsojka.myecom_product_service.dto.CreateProductRequestDto;
import dev.jsojka.myecom_product_service.dto.ProductDto;
import dev.jsojka.myecom_product_service.mapper.ProductMapper;
import dev.jsojka.myecom_product_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public ProductDto save(CreateProductRequestDto productDto) {
        ProductDto productToSave = productMapper.createProductRequestDtoToProductDto(productDto);
        return productRepository.save(productToSave);
    }
}
