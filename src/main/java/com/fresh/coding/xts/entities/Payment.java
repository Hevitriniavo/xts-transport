package com.fresh.coding.xts.entities;

import com.fresh.coding.xts.enums.PaymentMethod;
import com.fresh.coding.xts.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Getter
@Setter
@AllArgsConstructor
@ToString
@Builder
@NoArgsConstructor
@EqualsAndHashCode
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Reservation reservation;
    private Double amount;
    @Column(columnDefinition = "TIMESTAMP")
    private Instant paymentDate;
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;
}
