package com.fresh.coding.xts.services.impl;

import com.fresh.coding.xts.dtos.requests.ShipRequest;
import com.fresh.coding.xts.entities.Ship;
import com.fresh.coding.xts.exceptions.BadRequestException;
import com.fresh.coding.xts.mappers.ShipMapper;
import com.fresh.coding.xts.repositories.ShipRepository;
import com.fresh.coding.xts.services.ShipService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShipServiceImpl implements ShipService {
    private final ShipMapper shipMapper;
    private final ShipRepository shipRepository;

    @Override
    public Ship createOnlyShip(@NonNull ShipRequest shipRequest) {
        if (shipRequest.id() != null){
            throw new BadRequestException("If you want to create a new ship, you don't need to add an identifier");
        }
        var ship = shipMapper.toEntity(shipRequest);
        return shipRepository.save(ship);
    }

    @Override
    public List<Ship> findAllShips() {
        return shipRepository.findAll();
    }
}
