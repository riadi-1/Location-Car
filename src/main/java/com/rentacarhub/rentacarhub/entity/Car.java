package com.rentacarhub.rentacarhub.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;


@Entity
@Table(name = "car")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EnableTransactionManagement
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private Long id;
    private String brand;
    @Column(nullable = false)
    private String model;
    @Column(nullable = false)
    private Integer year;
    @Column(nullable = false)
    private String color;
    @Column(nullable = false)
    private String registrationNumber;
    @Column(nullable = false)
    private Boolean isAvailable;
    @Column(nullable = false)
    private Long rentPerDay;

    @OneToOne(mappedBy = "car")
    private Reservation reservation;

    // rental history one to many
    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RentalHistory> rentalHistories;

    @ManyToOne
    @JoinColumn(name = "partner_id")
    @JsonIgnore
    private Partner partner;

}
