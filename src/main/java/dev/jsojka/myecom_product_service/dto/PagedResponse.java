package dev.jsojka.myecom_product_service.dto;

import lombok.*;

import java.util.List;

@Builder
public record PagedResponse<T>(
        int currentPage,
        long totalItems,
        int totalPages,
        List<T> content
) { }