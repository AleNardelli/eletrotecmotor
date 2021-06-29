package br.com.eletrotecmotor.Dto;

import br.com.eletrotecmotor.modelo.Pecas;
import br.com.eletrotecmotor.modelo.Status;

public class DetalhesPecasDto {
	
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


	public DetalhesPecasDto(Pecas pecas) {
		
		this.nome = pecas.getNome();
		this.descricao = pecas.getDescricao();
		this.status = pecas.getStatus();
	}

	
}
