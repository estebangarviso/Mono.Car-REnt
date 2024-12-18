package com.mono_car_rent.modules.customer.dto;

public record CustomerUpdateDTO(
        /**
         * Customer's name.
         */
        String name,
        /**
         * Customer's validity.
         */
        Boolean validity
) {
}
