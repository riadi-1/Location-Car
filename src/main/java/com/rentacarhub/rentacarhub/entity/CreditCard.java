package com.rentacarhub.rentacarhub.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.time.LocalDate;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EnableTransactionManagement
@Table(name = "credit_card")
    public class CreditCard {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;
        @Column(unique = true)
        private Long cardNumber;
        @Column(nullable = false)
        private LocalDate validThru;
        @Column(nullable = false)
        private Integer cvv;
        @Column(nullable = false)
        private Long cardLimit;


        @OneToOne
        @JoinColumn(name = "user_id")
        @JsonIgnore
        private User user;

        //One to many mapping payment info
        @OneToMany(mappedBy = "creditCard", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<PaymentInfo> paymentInfos;
    }
