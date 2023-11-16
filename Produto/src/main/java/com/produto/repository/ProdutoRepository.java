package com.produto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.produto.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
