package com.easyclean.easycleanAPI.model;

import lombok.Data;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
@Table(name = "TB_CUSTOMER")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String name;

    @Column(unique = true)
    private String cpf;


}
