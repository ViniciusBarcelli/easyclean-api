package com.easyclean.easycleanAPI.repository;

import com.easyclean.easycleanAPI.model.ImagemProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagemProdutoRepository extends JpaRepository<ImagemProduto, Long> {
}
