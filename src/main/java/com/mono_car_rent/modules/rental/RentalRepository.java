package com.mono_car_rent.modules.rental;

import com.mono_car_rent.common.RepositoryInterface;
import java.util.HashMap;
import java.util.Map;

public class RentalRepository implements RepositoryInterface<Rental> {
    private static final int INITIAL_ID = 23453;
    private static Map<Integer, Rental> rentals = new HashMap<>();

    @Override
    public void save(Rental entity) {
        rentals.put(entity.getId(), entity);
    }

    @Override
    public void delete(int id) {
        rentals.remove(id);
    }

    @Override
    public void update(Rental entity) {
        rentals.put(entity.getId(), entity);
    }
    
    @Override
    public Rental findById(int id) {
        return rentals.get(id);
    }

    public static int nextId() {
        return rentals.size() + INITIAL_ID;
    }
}
