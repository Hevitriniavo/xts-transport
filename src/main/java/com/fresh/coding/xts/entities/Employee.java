package com.fresh.coding.xts.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
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
public class Employee extends User {
    private Double salary;
    @ManyToMany
    private List<Ship> ships = new ArrayList<>();
}
