package com.fresh.coding.xts.entities;

import jakarta.persistence.*;
import lombok.*;

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
public class Cabin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer number;
    private String type;
    private Integer capacity;
    private Integer deck;
    private Double price;
    @ManyToOne
    private Ship ship;
    @OneToMany(mappedBy = "cabin")
    private List<Reservation> reservations = new ArrayList<>();

}
