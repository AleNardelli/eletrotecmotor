package br.com.eletrotecmotor.Dto;

import org.springframework.data.domain.Page;

import br.com.eletrotecmotor.modelo.Produto;

public class ProdutoDto {

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

	public ProdutoDto(Produto produto) {
		this.id = produto.getId();
		this.nome = produto.getNome();
		this.descricao = produto.getDescricao();
	}

	public static Page<ProdutoDto> converter(Page<Produto> produto) {

		return produto.map(ProdutoDto::new);
	}

}
