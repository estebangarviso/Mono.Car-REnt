package com.mono_car_rent.modules.rental_return;

import com.mono_car_rent.common.RepositoryInterface;
import java.util.HashMap;
import java.util.Map;

public class RentalReturnRepository implements RepositoryInterface<RentalReturn> {
    private static Map<Integer, RentalReturn> rentalReturns = new HashMap<>();

    @Override
    public void save(RentalReturn entity) {
        rentalReturns.put(entity.getId(), entity);
    }

    @Override
    public void delete(int id) {
        rentalReturns.remove(id);
    }

    @Override
    public void update(RentalReturn entity) {
        rentalReturns.put(entity.getId(), entity);
    }
    
    @Override
    public RentalReturn findById(int id) {
        return rentalReturns.get(id);
    }

    public static int nextId() {
        return rentalReturns.size() + 1;
    }
}
