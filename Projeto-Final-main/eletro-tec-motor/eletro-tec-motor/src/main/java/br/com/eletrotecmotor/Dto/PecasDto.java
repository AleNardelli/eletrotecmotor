package br.com.eletrotecmotor.Dto;

import org.springframework.data.domain.Page;

import br.com.eletrotecmotor.modelo.Pecas;

public class PecasDto {

	private long id;
	private String descricao;
	private String nome;

	public long getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getNome() {
		return nome;
	}
	
	public PecasDto(Pecas pecas) {
		this.id = pecas.getId();
		this.nome = pecas.getNome();
		this.descricao = pecas.getDescricao();
	}

	

	public static Page<PecasDto> converter(Page<Pecas> pecas) {

		return pecas.map(PecasDto::new);
	}

}
