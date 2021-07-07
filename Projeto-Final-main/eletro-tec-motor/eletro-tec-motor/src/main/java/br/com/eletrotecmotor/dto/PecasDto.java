package br.com.eletrotecmotor.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.eletrotecmotor.modelo.Pecas;

	public class PecasDto {
		
	private Long id;
	private String descricao;
	private double precoUnitario;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return descricao;
	}
	
	public void setNome(String nome) {
		this.descricao = nome;
	}
	
	public double getPrecoUnitario() {
		return precoUnitario;
	}
	
	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}
	
	
	public static PecasDto conversao(Pecas pecas) {
		PecasDto dto = new PecasDto();
		dto.setId(pecas.getId());
		dto.setNome(pecas.getDescricao());
		dto.setPrecoUnitario(pecas.getPrecoUnitario());
		return dto;
	}
	
	public static List<PecasDto> conversao(List<Pecas> pecas){
		return pecas.stream().map(x->conversao(x)).collect(Collectors.toList());
	}

}