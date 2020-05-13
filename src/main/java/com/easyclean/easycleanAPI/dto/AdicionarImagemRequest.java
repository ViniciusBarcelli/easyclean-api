package com.easyclean.easycleanAPI.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdicionarImagemRequest {
    private String imagem;
    private Long IdProduto;
}
