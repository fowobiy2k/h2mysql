package com.fowobi.h2mysql.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Phone {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private int id;
    private String brand;
    private String model;
    private double weight;
}
