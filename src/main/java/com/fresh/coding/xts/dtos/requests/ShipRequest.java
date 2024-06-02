package com.fresh.coding.xts.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record ShipRequest(
        Long id,
        @NotBlank(message = "Name cannot be blank")
        String name,
        @NotNull(message = "Capacity cannot be null")
        @PositiveOrZero(message = "Capacity must be a positive number or zero")
        Integer capacity,
        @NotBlank(message = "Type cannot be blank")
        String type
) {}
