package com.easyclean.easycleanAPI.model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class ImagemProduto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Lob
    private byte[] imagem;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Produto produto;

}
