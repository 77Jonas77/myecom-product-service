package dev.jsojka.myecom_product_service.repository.jpa;

import dev.jsojka.myecom_product_service.model.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepositoryJpa extends JpaRepository<CategoryEntity, Integer> {
}
