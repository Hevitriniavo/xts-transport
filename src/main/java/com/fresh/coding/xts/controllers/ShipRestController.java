package com.fresh.coding.xts.controllers;

import com.fresh.coding.xts.dtos.requests.ShipRequest;
import com.fresh.coding.xts.entities.Ship;
import com.fresh.coding.xts.services.ShipService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/ships")
@RequiredArgsConstructor
public class ShipRestController {
    private final ShipService shipService;

    @PostMapping
    public Ship createOnlyShip(@RequestBody @Valid ShipRequest shipRequest){
        return shipService.createOnlyShip(shipRequest);
    }

    @GetMapping
    public List<Ship> getAllShips(){
        return shipService.findAllShips();
    }
}
