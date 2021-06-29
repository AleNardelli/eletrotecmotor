package br.com.eletrotecmotor.form;

import com.sun.istack.NotNull;

import br.com.eletrotecmotor.modelo.Produto;
import br.com.eletrotecmotor.repository.ProdutoRepository;

public class ProdutoForm {
	@NotNull 
	private String nome;
	@NotNull
	private String descricao;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Produto converter(ProdutoRepository produtoRepository) {
		Produto produto = produtoRepository.findBynome(nome);
		return new Produto(0, nome, descricao, null);
	}
	


}
