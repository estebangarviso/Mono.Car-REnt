package com.mono_car_rent.common;

public interface RepositoryInterface<T> {
    public void save(T entity);
    public void delete(int id);
    public void update(T entity);
    public T findById(int id);
}