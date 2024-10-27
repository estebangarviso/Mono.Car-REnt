package com.mono_car_rent.customer;

import java.util.HashMap;
import java.util.Map;
import com.mono_car_rent.common.RepositoryInterface;

public class CustomerRepository implements RepositoryInterface<CustomerModel> {
    private static Map<Integer, CustomerModel> customers = new HashMap<>();

    @Override
    public void save(CustomerModel entity) {
        customers.put(entity.getId(), entity);
    }

    @Override
    public void delete(int id) {
        customers.remove(id);
    }

    @Override
    public void update(CustomerModel entity) {
        customers.put(entity.getId(), entity);
    }
    
    @Override
    public CustomerModel findById(int id) {
        return customers.get(id);
    }

    public static int nextId() {
        return customers.size() + 1;
    }
    
}
