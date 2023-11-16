package com.produto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.produto.entities.Produto;
import com.produto.repository.ProdutoRepository;

@Service
public class ProdutoService {
	private ProdutoRepository produtoRepository;
	
	@Autowired
	public ProdutoService(ProdutoRepository usuarioRepository) {
		this.produtoRepository = usuarioRepository;
	}
	public List<Produto> buscarTodos(){
	return produtoRepository.findAll();
	}
	public Produto buscarId(Long id) {
		Optional <Produto> Produto = produtoRepository.findById(id);
		return Produto.orElse(null);
	}
	public Produto salvar(Produto usuario) {
		return produtoRepository.save(usuario);
	}
	public Produto alterar(Long id, Produto alterarprod) {
		Optional <Produto> existe  = produtoRepository.findById(id);
		if(existe.isPresent()) {
			alterarprod.setId(id);
			return produtoRepository.save(alterarprod);
		}
		return null;
	}
	public boolean apagar(Long id) {
		Optional <Produto> existe = produtoRepository.findById(id);
		if(existe.isPresent()) {
			produtoRepository.deleteById(id);
			return true;
		}
				
		return false;
	}

}


