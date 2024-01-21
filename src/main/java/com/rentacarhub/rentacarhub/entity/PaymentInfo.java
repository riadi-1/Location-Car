package com.rentacarhub.rentacarhub.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.time.LocalDateTime;


@Entity
@Table(name = "payment_info")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EnableTransactionManagement
public class PaymentInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private LocalDateTime date;
    private Long bill;

    //Many to one mapping credit card
    @ManyToOne
    @JoinColumn(name = "creditCard_id")
    @JsonIgnore
    private CreditCard creditCard;

}
