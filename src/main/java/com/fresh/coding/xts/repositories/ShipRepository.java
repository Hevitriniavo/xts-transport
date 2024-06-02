package com.fresh.coding.xts.repositories;

import com.fresh.coding.xts.entities.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipRepository extends JpaRepository<Ship, Long> {
}
