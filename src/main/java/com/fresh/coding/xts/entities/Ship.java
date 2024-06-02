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
public class Ship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer capacity;
    private String type;
    @OneToMany(mappedBy = "ship")
    private List<Cabin> cabins = new ArrayList<>();
    @ManyToMany
    private List<Company> companies = new ArrayList<>();
    @ManyToMany
    private List<Route> routes = new ArrayList<>();
    @ManyToMany
    private List<Employee> employees = new ArrayList<>();
    @ManyToMany
    private List<Passenger> passengers = new ArrayList<>();
    @OneToMany(mappedBy = "ship")
    private List<Reservation> reservations = new ArrayList<>();
}
