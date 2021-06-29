package br.com.eletrotecmotor.Dto;

import br.com.eletrotecmotor.modelo.Produto;
import br.com.eletrotecmotor.modelo.Status;

public class DetalhesProdutoDto {
	
	private String nome;
	private String descricao;
	private Status status;
	
	
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


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}


	public DetalhesProdutoDto(Produto produto) {
		
		this.nome = produto.getNome();
		this.descricao = produto.getDescricao();
		this.status = produto.getStatus();
	}

	
}
