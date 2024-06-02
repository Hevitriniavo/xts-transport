package com.fresh.coding.xts.services;

import com.fresh.coding.xts.dtos.requests.ShipRequest;
import com.fresh.coding.xts.entities.Ship;
import lombok.NonNull;

import java.util.List;

public interface ShipService {
    Ship createOnlyShip(@NonNull ShipRequest shipRequest);
    List<Ship> findAllShips();
}
