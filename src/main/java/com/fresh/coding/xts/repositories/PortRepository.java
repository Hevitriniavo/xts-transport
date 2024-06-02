package com.fresh.coding.xts.repositories;

import com.fresh.coding.xts.entities.Port;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortRepository extends JpaRepository<Port, Long> {
}
