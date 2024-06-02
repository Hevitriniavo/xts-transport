package com.fresh.coding.xts.entities;

import com.fresh.coding.xts.enums.ReservationStatus;
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
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Passenger passenger;
    @ManyToOne
    private Ship ship;
    @ManyToOne
    private Cabin cabin;
    @ManyToOne
    private Route route;
    private Instant reservationDate;
    @Enumerated(EnumType.STRING)
    private ReservationStatus status;
    private Double fee;
    @OneToMany(mappedBy = "reservation")
    private List<Payment> payments = new ArrayList<>();
}
