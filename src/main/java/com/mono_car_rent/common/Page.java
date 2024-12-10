package com.mono_car_rent.common;

import java.util.List;
import lombok.Data;

@Data
public class Page<T> {
    private int currentPage;
    private int pageSize;
    private List<T> items;
    private int totalItems;
    private int totalPages;
}
