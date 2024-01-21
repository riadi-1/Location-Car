package com.rentacarhub.rentacarhub.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.time.LocalDateTime;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EnableTransactionManagement
@Table(name = "rental_history")
public class RentalHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Long rentPerDay;
    private String address;


    // User many-to-one mapping
    @ManyToOne
    @JoinColumn(name = "user_id") // The name of the foreign key column in the RentalHistory table
    @JsonIgnore
    private User user;

    // Car many-to-one mapping
    @ManyToOne
    @JoinColumn(name = "car_id")
    @JsonIgnore
    private Car car;


}
