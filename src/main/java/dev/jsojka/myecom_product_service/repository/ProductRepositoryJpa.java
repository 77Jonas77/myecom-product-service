package dev.jsojka.myecom_product_service.repository;

import dev.jsojka.myecom_product_service.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepositoryJpa extends JpaRepository<ProductEntity, UUID> {

}
