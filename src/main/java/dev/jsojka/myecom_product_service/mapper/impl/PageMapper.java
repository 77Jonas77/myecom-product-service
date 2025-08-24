package dev.jsojka.myecom_product_service.mapper.impl;

import dev.jsojka.myecom_product_service.dto.PagedResponse;
import org.springframework.data.domain.Page;

public final class PageMapper {
    private PageMapper() {
    }

    public static <T> PagedResponse<T> toPagedResponse(Page<T> page) {
        return PagedResponse.<T>builder()
                .totalPages(page.getTotalPages())
                .currentPage(page.getNumber())
                .totalItems(page.getTotalElements())
                .content(page.getContent())
                .build();
    }
}
