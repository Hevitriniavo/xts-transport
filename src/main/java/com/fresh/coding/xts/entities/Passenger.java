package com.fresh.coding.xts.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@ToString
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Passenger extends User {
    @ManyToMany
    private List<Ship> ships = new ArrayList<>();
    @OneToMany(mappedBy = "passenger")
    private List<Reservation> reservations = new ArrayList<>();
}
