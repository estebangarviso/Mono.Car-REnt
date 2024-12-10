package com.mono_car_rent.common;

public record Pageable (
    /**
     * Page number.
     */
    int page,
    /**
     * Page size.
     */
    int size
) {}
