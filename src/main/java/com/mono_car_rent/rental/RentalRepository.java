package com.mono_car_rent.rental;

import java.util.HashMap;
import java.util.Map;
import com.mono_car_rent.common.RepositoryInterface;

public class RentalRepository implements RepositoryInterface<RentalModel> {
    private static Map<Integer, RentalModel> rentals = new HashMap<>();

    @Override
    public void save(RentalModel entity) {
        rentals.put(entity.getId(), entity);
    }

    @Override
    public void delete(int id) {
        rentals.remove(id);
    }

    @Override
    public void update(RentalModel entity) {
        rentals.put(entity.getId(), entity);
    }
    
    @Override
    public RentalModel findById(int id) {
        return rentals.get(id);
    }

    public static int nextId() {
        return rentals.size() + 1;
    }
    
}
