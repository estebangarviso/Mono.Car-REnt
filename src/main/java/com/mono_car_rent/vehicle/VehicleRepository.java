package com.mono_car_rent.vehicle;

import java.util.HashMap;
import java.util.Map;
import com.mono_car_rent.common.RepositoryInterface;

public class VehicleRepository implements RepositoryInterface<VehicleModel> {
    private static Map<Integer, VehicleModel> vehicles = new HashMap<>();

    @Override
    public void save(VehicleModel entity) {
        vehicles.put(entity.getId(), entity);
    }

    @Override
    public void delete(int id) {
        vehicles.remove(id);
    }

    @Override
    public void update(VehicleModel entity) {
        vehicles.put(entity.getId(), entity);
    }
    
    @Override
    public VehicleModel findById(int id) {
        return vehicles.get(id);
    }

    public static int nextId() {
        return vehicles.size() + 1;
    }
}
