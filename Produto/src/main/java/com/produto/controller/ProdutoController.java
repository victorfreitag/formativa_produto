package com.produto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produto.entities.Produto;
import com.produto.service.ProdutoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name= "Produto",description = "API REST DE GERENCIAMENTO DE USUÁRIOS")
@RestController
@RequestMapping("/produto")
public class ProdutoController {
	
private final ProdutoService produtoService;
	
	@Autowired
	public ProdutoController(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}
	
	@GetMapping("/{id}")
	@Operation(summary = "Localiza usuario por ID")
	public ResponseEntity<Produto> buscarId(@PathVariable Long id){
		Produto produto = produtoService.buscarId(id);
		if(produto != null) {
			return ResponseEntity.ok(produto);
		}
		else {
			return ResponseEntity.notFound().build();
		}}
	
		@GetMapping("/")
		@Operation(summary = "Apresenta todos os usuarios")
		public ResponseEntity <List<Produto>> buscartodos(){
		List<Produto> produto = produtoService.buscarTodos();
		return ResponseEntity.ok(produto);
	}
		@PostMapping("/")
		@Operation(summary = "Inserindo Dados")
		public ResponseEntity<Produto>salvar(@RequestBody @Valid Produto produto){
			Produto salvar = produtoService.salvar(produto);
			return ResponseEntity.status(HttpStatus.CREATED).body(salvar);
		}
		@PutMapping("/")
		@Operation(summary = "Aterando Dados")
		public ResponseEntity<Produto> alterar(@PathVariable Long id, @RequestBody @Valid Produto produto){
			Produto alterar = produtoService.alterar(id, produto);
			if(alterar !=null) {
				return ResponseEntity.ok(produto);
			}
			else {
				return ResponseEntity.notFound().build();
			}
		}
			@DeleteMapping("/{id}")
			@Operation(summary = "Deletando Dados")
			public ResponseEntity<Produto> apagar(@PathVariable Long id){
				boolean apagar = produtoService.apagar(id);
				if(apagar) {
					return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
				}
				else {
					return ResponseEntity.notFound().build();
				}
			}
		}
	


