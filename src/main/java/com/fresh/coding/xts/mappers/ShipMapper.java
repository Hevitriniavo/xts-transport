package com.fresh.coding.xts.mappers;

import com.fresh.coding.xts.dtos.requests.ShipRequest;
import com.fresh.coding.xts.dtos.responses.ShipResponse;
import com.fresh.coding.xts.entities.Ship;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
public class ShipMapper {

    public ShipResponse toResponse(@NonNull Ship ship){
        return new ShipResponse(
                ship.getId(),
                ship.getName(),
                ship.getCapacity(),
                ship.getType()
        );
    }

    public Ship toEntity(@NonNull ShipRequest request){
        return Ship.builder()
                .id(request.id())
                .name(request.name())
                .type(request.type())
                .capacity(request.capacity())
                .build();
    }
}
