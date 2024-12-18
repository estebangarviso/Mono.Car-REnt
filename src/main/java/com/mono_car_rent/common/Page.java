package com.mono_car_rent.common;

import java.util.List;

public class Page<T> {
    private int currentPage;
    private int pageSize;
    private List<T> items;
    private int totalItems;
    private int totalPages;

    public Page() {
    }

    public int getCurrentPage() {
        return this.currentPage;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public List<T> getItems() {
        return this.items;
    }

    public int getTotalItems() {
        return this.totalItems;
    }

    public int getTotalPages() {
        return this.totalPages;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Page)) return false;
        final Page<?> other = (Page<?>) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getCurrentPage() != other.getCurrentPage()) return false;
        if (this.getPageSize() != other.getPageSize()) return false;
        final Object this$items = this.getItems();
        final Object other$items = other.getItems();
        if (this$items == null ? other$items != null : !this$items.equals(other$items)) return false;
        if (this.getTotalItems() != other.getTotalItems()) return false;
        if (this.getTotalPages() != other.getTotalPages()) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Page;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getCurrentPage();
        result = result * PRIME + this.getPageSize();
        final Object $items = this.getItems();
        result = result * PRIME + ($items == null ? 43 : $items.hashCode());
        result = result * PRIME + this.getTotalItems();
        result = result * PRIME + this.getTotalPages();
        return result;
    }

    public String toString() {
        return "Page(currentPage=" + this.getCurrentPage() + ", pageSize=" + this.getPageSize() + ", items=" + this.getItems() + ", totalItems=" + this.getTotalItems() + ", totalPages=" + this.getTotalPages() + ")";
    }
}
