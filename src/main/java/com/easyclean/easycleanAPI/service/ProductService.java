package com.easyclean.easycleanAPI.service;

import com.easyclean.easycleanAPI.dto.AdicionarImagemRequest;
import com.easyclean.easycleanAPI.model.ImagemProduto;
import com.easyclean.easycleanAPI.model.Produto;
import com.easyclean.easycleanAPI.repository.ImagemProdutoRepository;
import com.easyclean.easycleanAPI.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Optional;



@Service
public class ProductService {
    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    ImagemProdutoRepository imagemProdutoRepository;


    public ImagemProduto addImagem(AdicionarImagemRequest request){
        ImagemProduto imagemProduto= null;
        Optional<Produto> produto = produtoRepository.findById(request.getIdProduto()
        );
        if (produto.isPresent()){
            imagemProduto = new ImagemProduto();
            imagemProduto.setProduto(produto.get());
            imagemProduto.setImagem(Base64.getDecoder().decode(request.getImagem()));
            imagemProdutoRepository.save(imagemProduto);
        }
        return imagemProduto;
    }

    public Produto findById(Long id) throws Exception {
       return Optional.ofNullable(produtoRepository.findById(id)
               .orElseThrow(() -> new Exception("Produto não encontrado!"))).get();

    }


}
