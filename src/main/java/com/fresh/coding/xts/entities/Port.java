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
public class Port {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String city;
    @ManyToOne
    private Country country;
    @ManyToMany
    private List<Route> routes = new ArrayList<>();
}
