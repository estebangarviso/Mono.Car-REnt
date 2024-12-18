package com.mono_car_rent.modules.vehicle;

import com.mono_car_rent.common.AbstractRepository;
import com.google.gson.reflect.TypeToken;
import com.mono_car_rent.common.Page;
import com.mono_car_rent.common.Pageable;
import com.mono_car_rent.common.RepositoryResponse;
import com.mono_car_rent.common.exception.general.BadRequestException;
import com.mono_car_rent.modules.vehicle.dto.VehicleSaveDTO;
import com.mono_car_rent.modules.vehicle.dto.VehicleUpdateDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

public class VehicleRepository extends AbstractRepository<Vehicle> {
    private VehicleRepository() {
        super("vehicles.json", new TypeToken<ArrayList<Vehicle>>() {});
    }

    /**
     * Saves a vehicle.
     *
     * @param vehicleSaveDTO the vehicle to save
     */
    public RepositoryResponse<Vehicle> save(VehicleSaveDTO vehicleSaveDTO) {
        Vehicle newVehicle = Vehicle.builder()
                .plate(vehicleSaveDTO.plate())
                .brand(vehicleSaveDTO.brand())
                .model(vehicleSaveDTO.model())
                .year(vehicleSaveDTO.year())
                .build();
        return super.save(newVehicle);
    }

    /**
     * Finds a vehicle by plate.
     *
     * @param plate the plate to search
     * @return the vehicle found or null
     */
    public RepositoryResponse<Vehicle> findByPlate(String plate) {
        for (Vehicle vehicle : this.getAll()) {
            if (vehicle.getPlate().equals(plate)) {
                return RepositoryResponse.<Vehicle>builder()
                        .success(true)
                        .value(vehicle)
                        .build();
            }
        }
        return RepositoryResponse.<Vehicle>builder()
                .success(false)
                .build();
    }

    public RepositoryResponse<Page<Vehicle>> paginate(Pageable pageable, Optional<String> filter) {
        int page = pageable.page();
        int size = pageable.size();
        List<Vehicle> allVehicles = this.getAll();

        // Apply filter
        List<Vehicle> activeVehiclesList = new ArrayList<>();
        if (filter.isEmpty()) {
            activeVehiclesList = allVehicles;
        } else {
            String filterValue = filter.get();
            for (Vehicle vehicle : allVehicles) {
                if (vehicle.getPlate().contains(filterValue) || vehicle.getBrand().contains(filterValue) || vehicle.getModel().contains(filterValue)) {
                    activeVehiclesList.add(vehicle);
                }
            }
        }

        int totalItems = activeVehiclesList.size();
        int totalPages = (int) Math.ceil((double) totalItems / size);
        if (page < 1 || page > totalPages) {
            return RepositoryResponse.<Page<Vehicle>>builder()
                    .success(false)
                    .error(BadRequestException.invalidPage(page, totalPages))
                    .build();
        }
        List<Vehicle> items = activeVehiclesList.stream()
                .skip((page - 1) * size)
                .limit(size)
                .toList();

        Page<Vehicle> vehiclePage = new Page<Vehicle>();
        vehiclePage.setCurrentPage(page);
        vehiclePage.setPageSize(size);
        vehiclePage.setItems(items);
        vehiclePage.setTotalItems(totalItems);
        vehiclePage.setTotalPages(totalPages);

        return RepositoryResponse.<Page<Vehicle>>builder()
                .success(true)
                .value(vehiclePage)
                .build();
    }
    // update method
    public RepositoryResponse<Vehicle> update(String plate, VehicleUpdateDTO vehicle) {
        RepositoryResponse<Vehicle> repositoryResponse = this.findByPlate(plate);
        if (!repositoryResponse.isSuccess()) {
            return RepositoryResponse.<Vehicle>builder()
                    .success(false)
                    .build();
        }
        Vehicle found = repositoryResponse.getValue();
        found.setBrand(vehicle.brand());
        found.setModel(vehicle.model());
        found.setYear(vehicle.year());
        found.setCondition(VehicleConditionStatus.valueOf(vehicle.condition()));
        found.toBuilder().build();
        return super.update(repositoryResponse.getIndex(), found);
    }
    //#region Singleton
    private static final AtomicReference<VehicleRepository> instance = new AtomicReference<>();
    public static VehicleRepository getInstance() {
        if (instance.get() == null) {
            instance.set(new VehicleRepository());
        }
        return instance.get();
    }
    //#endregion
}
