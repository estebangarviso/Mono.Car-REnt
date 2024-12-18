package com.mono_car_rent.modules.vehicle.dto;

public record VehicleSaveDTO(
        /**
         * Vehicle's plate.
         */
        String plate,
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
        int year
) {
}
