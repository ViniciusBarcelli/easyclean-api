package com.easyclean.easycleanAPI.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "TB_PRODUTO")
public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idProduto;
    private String nome;
    private String descricao;
    private BigDecimal valor;

}
