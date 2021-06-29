package br.com.eletrotecmotor.form;

import com.sun.istack.NotNull;

import br.com.eletrotecmotor.modelo.Produto;
import br.com.eletrotecmotor.repository.ProdutoRepository;

public class AtualiazaoProdutoForm {

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
	public Produto atualizar(Long id, ProdutoRepository produtoRepository) {
	Produto produto = produtoRepository.getOne(id);
	produto.setNome(this.nome);
	
	produto.setDescricao(this.descricao);
		return produto;
	}
	
	
}
