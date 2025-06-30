package com.cvckcorp.backend_quanto_ta.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String fant;
    private String cnpj;
    private String address;
    private int number;
    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private List<Product> products;
}
