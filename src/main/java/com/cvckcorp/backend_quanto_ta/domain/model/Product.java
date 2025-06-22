package com.cvckcorp.backend_quanto_ta.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String name;
    private String unit;
    private double amount;
    private double price;
    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;
}
