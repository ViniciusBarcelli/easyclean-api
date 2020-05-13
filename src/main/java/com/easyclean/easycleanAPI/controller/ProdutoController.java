package com.easyclean.easycleanAPI.controller;


import com.easyclean.easycleanAPI.dto.AdicionarImagemRequest;
import com.easyclean.easycleanAPI.model.ImagemProduto;
import com.easyclean.easycleanAPI.model.Produto;
import com.easyclean.easycleanAPI.repository.ImagemProdutoRepository;
import com.easyclean.easycleanAPI.repository.ProdutoRepository;
import com.easyclean.easycleanAPI.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/produtos")

@Configuration
public class ProdutoController {

    @Autowired
    ProductService productService;

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**");
            }
        };
    }

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    ImagemProdutoRepository imagemProdutoRepository;

    @GetMapping("{id}")
    public Produto findById(@PathVariable Long id) throws Exception {
        return productService.findById(id);
    }

    @GetMapping("/produtos")
    public List<Produto> listaProdutos() {
        return produtoRepository.findAll();
    }

    @GetMapping("/imagens")
    public List<ImagemProduto> listaImagem(){
        return imagemProdutoRepository.findAll();
    }


    @PostMapping
    public Produto create(@RequestBody Produto produto){
        return produtoRepository.save(produto);
    }

    @PostMapping("/addProductImage")
    public ImagemProduto addImagem(@RequestBody AdicionarImagemRequest request){
       return productService.addImagem(request);
    }
}

