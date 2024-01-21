    package com.rentacarhub.rentacarhub.entity;

    import com.fasterxml.jackson.annotation.JsonIgnore;
    import jakarta.persistence.*;
    import lombok.AllArgsConstructor;
    import lombok.Data;
    import lombok.NoArgsConstructor;
    import org.springframework.transaction.annotation.EnableTransactionManagement;

    import java.util.List;

    @Entity
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @EnableTransactionManagement
    @Table(name = "partner")
        public class Partner {

            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            @Column(name = "id")
            private Long id;
            @Column(nullable = false)
            private String firstName;
            @Column(nullable = false)
            private String lastName;
            @Column(nullable = false)
            private String password;
        @Column(nullable = false)
            private String phone;
            @Column(unique = true)
            private String email;
        @Column(nullable = false)
            private String address;


            @OneToMany(mappedBy = "partner",cascade = CascadeType.ALL)
            private List<Car> cars;

            @OneToMany(mappedBy = "partner",cascade = CascadeType.ALL)
            private List<TempCar> tempCars;

        }
