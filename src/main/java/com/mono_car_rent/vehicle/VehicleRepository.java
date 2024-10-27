package com.mono_car_rent.vehicle;

import java.util.HashMap;
import java.util.Map;
import com.mono_car_rent.common.RepositoryInterface;

public class VehicleRepository implements RepositoryInterface<Vehicle> {
    private static Map<Integer, Vehicle> vehicles = new HashMap<>();

    @Override
    public void save(Vehicle entity) {
        vehicles.put(entity.getId(), entity);
    }

    @Override
    public void delete(int id) {
        vehicles.remove(id);
    }

    @Override
    public void update(Vehicle entity) {
        vehicles.put(entity.getId(), entity);
    }
    
    @Override
    public Vehicle findById(int id) {
        return vehicles.get(id);
    }

    public static int nextId() {
        return vehicles.size() + 1;
    }
}
