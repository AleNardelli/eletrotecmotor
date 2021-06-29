package br.com.eletrotecmotor.form;

import com.sun.istack.NotNull;

import br.com.eletrotecmotor.modelo.Pecas;
import br.com.eletrotecmotor.repository.PecasRepository;

public class AtualizacaoPecasForm {

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

	public Pecas atualizar(Long id, PecasRepository pecasRepository) {
		Pecas pecas = pecasRepository.getOne(id);
		pecas.setNome(this.nome);

		pecas.setDescricao(this.descricao);
		return pecas;
	}

}
