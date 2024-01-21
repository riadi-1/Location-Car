package com.rentacarhub.rentacarhub.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EnableTransactionManagement
public class PartnerPaymentInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  Long id;
    private String registrationNumber;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Long rentPerDay ;


    @ManyToOne
    @JoinColumn(name = "partner_id")
    private Partner partner;
//
//    @ManyToOne
//    @JoinColumn(name = "reservation_id")
//    private Reservation reservation;


}
