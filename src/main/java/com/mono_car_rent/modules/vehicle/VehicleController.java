package com.mono_car_rent.modules.vehicle;

import com.mono_car_rent.common.Page;
import com.mono_car_rent.common.Pageable;
import com.mono_car_rent.modules.vehicle.dto.VehicleSaveDTO;
import com.mono_car_rent.modules.vehicle.dto.VehicleUpdateDTO;

import java.util.Optional;

public class VehicleController {
    private final VehicleService vehicleService = new VehicleService();

    public Vehicle create(VehicleSaveDTO vehicleSaveDTO) throws Throwable {
        return vehicleService.create(vehicleSaveDTO);
    }

    public Vehicle get(String plate) throws Throwable {
        return vehicleService.get(plate);
    }

    public Page<Vehicle> paginate(Pageable pageable, Optional<String> filter) throws Throwable {
        return vehicleService.paginate(pageable, filter);
    }

    public Vehicle update(String plate, VehicleUpdateDTO vehicleUpdateDTO) throws Throwable {
        return vehicleService.update(plate, vehicleUpdateDTO);
    }
}
