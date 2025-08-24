package dev.jsojka.myecom_product_service.repository;

import dev.jsojka.myecom_product_service.model.ProductEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public interface ProductRepositoryJpa extends JpaRepository<ProductEntity, UUID> {

    @Modifying
    @Query("update ProductEntity p set p.productId=:productId, p.productTitle=:productTitle, p.imageUrl=:imageUrl," +
            "p.priceUnit=:priceUnit, p.quantity=:quantity, p.updatedAt=:updatedAt")
    void updateByProductId(
            @Param("productId") UUID productId,
            @Param("productTitle") String productTitle,
            @Param("quantity") Integer quantity,
            @Param("imageUrl") String imageUrl,
            @Param("priceUnit") BigDecimal priceUnit,
            @Param("updatedAt") Instant updatedAt
    );
}
