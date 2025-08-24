package dev.jsojka.myecom_product_service.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products", schema = "products")
@Builder
@Entity
public class ProductEntity extends AbstractEntitySuperclass implements Serializable {

    @Id
    @Column(name = "product_id", unique = true, nullable = false)
    private UUID productId;

    @Column(name = "product_title", nullable = false)
    private String productTitle;

    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    @Column(name = "price_unit", nullable = false)
    private BigDecimal priceUnit;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private CategoryEntity category;
}
