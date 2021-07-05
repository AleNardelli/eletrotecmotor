package br.com.eletrotecmotor.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Pecas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pecas")
	private Long id;
	private String nomePeca;
	private String descricao;
	private double precoUnitario;

	public Pecas() {
		
	}
	
	@ManyToOne
	private Servico servico;

	

	public Pecas(Long id, String nomePeca, String descricao, double precoUnitario, Servico servico) {
		this.id = id;
		this.nomePeca = nomePeca;
		this.descricao = descricao;
		this.precoUnitario = precoUnitario;
		this.servico = servico;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomePeca() {
		return nomePeca;
	}

	public void setNomePeca(String nomePeca) {
		this.nomePeca = nomePeca;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}
	
	
	
	
	

}	