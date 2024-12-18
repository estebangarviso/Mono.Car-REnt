package com.mono_car_rent.modules.vehicle.use_case;

import com.mono_car_rent.common.Page;
import com.mono_car_rent.common.Pageable;
import com.mono_car_rent.modules.vehicle.Vehicle;
import com.mono_car_rent.modules.vehicle.dto.VehicleSaveDTO;
import com.mono_car_rent.modules.vehicle.dto.VehicleUpdateDTO;

import java.util.Optional;

public interface VehicleCRUDUseCase {
    Vehicle create(VehicleSaveDTO vehicleSaveDTO) throws Throwable;

    Vehicle get(String plate) throws Throwable;

    Page<Vehicle> paginate(Pageable pageable, Optional<String> filter) throws Throwable;

    Vehicle update(String plate, VehicleUpdateDTO vehicleUpdateDTO) throws Throwable;
}
