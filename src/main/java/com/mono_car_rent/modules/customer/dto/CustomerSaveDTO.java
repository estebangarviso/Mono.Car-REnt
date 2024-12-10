package com.mono_car_rent.modules.customer.dto;

public record CustomerSaveDTO(
        /**
         * Customer's identity card.
         */
        String identityCard,
        /**
         * Customer's name.
         */
        String name
) {
}
