package com.mono_car_rent.modules.vehicle.dto;

import com.mono_car_rent.modules.vehicle.VehicleConditionStatus;

public record VehicleUpdateDTO(
        /**
         * Vehicle's brand.
         */
        String brand,
        /**
         * Vehicle's model.
         */
        String model,
        /**
         * Vehicle's year.
         */
        Integer year,
        /**
         * Vehicle's condition.
         * @see VehicleConditionStatus for possible values.
         * @see Example: "DISPONIBLE" -> VehicleConditionStatus.DISPONIBLE
         */
        String condition
) {
}
