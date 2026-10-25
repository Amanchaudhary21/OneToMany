package com.example.onetomany.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  //order_id


    @NotNull(message = "Please enter your orderName")
    private String orderName;
    private LocalDateTime orderDate;

    @ManyToOne(fetch = FetchType.LAZY)
//    @JsonIgnore
    private Person person;

}
