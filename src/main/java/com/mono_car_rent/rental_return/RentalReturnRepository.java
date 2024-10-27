package com.mono_car_rent.rental_return;

import java.util.HashMap;
import java.util.Map;
import com.mono_car_rent.common.RepositoryInterface;

public class RentalReturnRepository implements RepositoryInterface<RentalReturnModel> {
    private static Map<Integer, RentalReturnModel> rentalReturns = new HashMap<>();

    @Override
    public void save(RentalReturnModel entity) {
        rentalReturns.put(entity.getId(), entity);
    }

    @Override
    public void delete(int id) {
        rentalReturns.remove(id);
    }

    @Override
    public void update(RentalReturnModel entity) {
        rentalReturns.put(entity.getId(), entity);
    }
    
    @Override
    public RentalReturnModel findById(int id) {
        return rentalReturns.get(id);
    }

    public static int nextId() {
        return rentalReturns.size() + 1;
    }
}
