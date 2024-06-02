package com.fresh.coding.xts.repositories;

import com.fresh.coding.xts.entities.Cabin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CabinRepository  extends JpaRepository<Cabin, Long> {
}
