package com.mono_car_rent.modules.customer;

import com.mono_car_rent.common.RepositoryInterface;
import java.util.HashMap;
import java.util.Map;

public class CustomerRepository implements RepositoryInterface<Customer> {
    private static Map<Integer, Customer> customers = new HashMap<>();

    @Override
    public void save(Customer entity) {
        customers.put(entity.getId(), entity);
    }

    @Override
    public void delete(int id) {
        customers.remove(id);
    }

    @Override
    public void update(Customer entity) {
        customers.put(entity.getId(), entity);
    }
    
    @Override
    public Customer findById(int id) {
        return customers.get(id);
    }

    public static int nextId() {
        return customers.size() + 1;
    }
    
}
