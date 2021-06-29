package br.com.eletrotecmotor.form;

import com.sun.istack.NotNull;

import br.com.eletrotecmotor.modelo.Pecas;
import br.com.eletrotecmotor.repository.PecasRepository;

public class PecasForm {
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
	
	
	public Pecas converter(PecasRepository pecasRepository) {
	return new Pecas(0, nome, descricao, null);
	}
	


}
