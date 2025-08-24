package dev.jsojka.myecom_product_service.controller;

import dev.jsojka.myecom_product_service.dto.ApiResponse;
import dev.jsojka.myecom_product_service.dto.product.CreateProductRequestDto;
import dev.jsojka.myecom_product_service.dto.product.ProductDto;
import dev.jsojka.myecom_product_service.dto.product.UpdateProductRequestDto;
import dev.jsojka.myecom_product_service.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductDto> save(@RequestBody @Valid CreateProductRequestDto requestDto) {
        ProductDto response = productService.save(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDto> findById(@PathVariable UUID productId) {
        ProductDto response = productService.findById(productId);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<ApiResponse> updateById(@PathVariable UUID productId, @RequestBody @Valid UpdateProductRequestDto requestDto) {
        productService.updateById(productId, requestDto);
        return ResponseEntity.ok(new ApiResponse("Product with id: " + productId + "updated successfully."));
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<ApiResponse> deleteById(@PathVariable UUID productId) {
        productService.deleteById(productId);
        return ResponseEntity.ok(new ApiResponse("Product with id: " + productId + " successfully deleted."));
    }

}
