package com.fresh.coding.xts.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@ToString
@Builder
@NoArgsConstructor
@EqualsAndHashCode
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column( columnDefinition = "TIMESTAMP")
    private Instant departureDate;
    @Column(columnDefinition = "TIMESTAMP")
    private Instant arrivalDate;
    @ManyToMany
    private List<Port> ports = new ArrayList<>();
    @ManyToMany
    private List<Ship> ships = new ArrayList<>();
    @OneToMany(mappedBy = "route")
    private List<Reservation> reservations = new ArrayList<>();
}
