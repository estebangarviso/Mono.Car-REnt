package com.mono_car_rent.modules.vehicle;

import com.mono_car_rent.common.Page;
import com.mono_car_rent.common.Pageable;
import com.mono_car_rent.common.RepositoryResponse;
import com.mono_car_rent.modules.vehicle.dto.VehicleSaveDTO;
import com.mono_car_rent.modules.vehicle.dto.VehicleUpdateDTO;
import com.mono_car_rent.modules.vehicle.use_case.VehicleCRUDUseCase;

import java.util.Optional;

public class VehicleService implements VehicleCRUDUseCase {
    private final VehicleRepository vehicleRepository = VehicleRepository.getInstance();

    @Override
    public Vehicle create(VehicleSaveDTO vehicleSaveDTO) throws Throwable {
        RepositoryResponse<Vehicle> saved = vehicleRepository.save(vehicleSaveDTO);

        if (!saved.isSuccess()) {
            throw saved.getError();
        }

        return saved.getValue();
    }

    @Override
    public Vehicle get(String plate) throws Throwable {
        RepositoryResponse<Vehicle> found = vehicleRepository.findByPlate(plate);

        if (!found.isSuccess()) {
            throw found.getError();
        }

        return found.getValue();
    }

    @Override
    public Page<Vehicle> paginate(Pageable pageable, Optional<String> filter) throws Throwable {
        RepositoryResponse<Page<Vehicle>> paginated = vehicleRepository.paginate(pageable, filter);

        if (!paginated.isSuccess()) {
            throw paginated.getError();
        }

        return paginated.getValue();
    }

    @Override
    public Vehicle update(String plate, VehicleUpdateDTO vehicleUpdateDTO) throws Throwable {
        RepositoryResponse<Vehicle> updated = vehicleRepository.update(plate, vehicleUpdateDTO);

        if (!updated.isSuccess()) {
            throw updated.getError();
        }

        return updated.getValue();
    }

}
