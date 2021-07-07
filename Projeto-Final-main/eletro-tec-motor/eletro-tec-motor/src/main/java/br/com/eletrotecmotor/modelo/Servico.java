package br.com.eletrotecmotor.modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Servico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;                 //gerado automaticamente
	private String descricaoServico;
	private LocalDateTime dataEntrada;  //gerado automaticamente
	private LocalDate prazoConclusao;
	private double total;  //valor mão de obra + peças //gerado automaticamente
	@ManyToOne
	private Cliente cliente;
	@ManyToMany
	private List<Pecas> pecas;

	
	//construtor necessário pra soma de Peças
	
	
	public Servico() {
		
	}
	
	public Servico(String descricaoServico, LocalDateTime dataEntrada,
			LocalDate prazoConclusao, double total, Cliente cliente, List<Pecas> pecas) {
		this.descricaoServico = descricaoServico;
		this.dataEntrada = dataEntrada;
		this.prazoConclusao = prazoConclusao;
		this.total = total;
		this.cliente = cliente;
		this.pecas = pecas;
	}

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}


	public String getDescricaoServico() {
		return descricaoServico;
	}



	public void setDescricaoServico(String descricaoServico) {
		this.descricaoServico = descricaoServico;
	}



	public LocalDateTime getDataEntrada() {
		return dataEntrada;
	}



	public void setDataEntrada(LocalDateTime dataEntrada) {
		this.dataEntrada = dataEntrada;
	}



	public LocalDate getPrazoConclusao() {
		return prazoConclusao;
	}



	public void setPrazoConclusao(LocalDate prazoConclusao) {
		this.prazoConclusao = prazoConclusao;
	}



	public double getTotal() {
		return total;
	}



	public void setTotal(double total) {
		this.total = total;
	}



	public Cliente getCliente() {
		return cliente;
	}



	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}



	public List<Pecas> getPecas() {
		return pecas;
	}



	public void setPecas(List<Pecas> pecas) {
		this.pecas = pecas;
	}
	
	

}
	