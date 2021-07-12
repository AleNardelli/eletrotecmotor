package br.com.eletrotecmotor.modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;


@Entity
public class Servico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;                 //gerado automaticamente
	private String descricaoServico;
	private LocalDate dataEntrada = LocalDate.now();  //gerado automaticamente
	private LocalDate prazoConclusao;
	private double total;  //valor mão de obra + peças //gerado automaticamente
	@Enumerated
	private Status status = Status.Aberto;
	@ManyToOne
	private Cliente cliente;
	@ManyToMany
	private List<Pecas> pecas;
	

	//constutor necessário para a soma 
	
	
	public Servico() {
		
	}
	

	public Servico(String descricaoServico, LocalDate dataEntrada, LocalDate prazoConclusao, double total, Status status,
			Cliente cliente, List<Pecas> pecas) {
		this.descricaoServico = descricaoServico;
		this.dataEntrada = dataEntrada;
		this.prazoConclusao = prazoConclusao;
		this.total = total;
		this.status = status;
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


	public LocalDate getDataEntrada() {
		return dataEntrada;
	}



	public void setDataEntrada(LocalDate dataEntrada) {
		this.dataEntrada = dataEntrada;
	}



	public LocalDate getPrazoConclusao() {
		return prazoConclusao;
	}



	public void setPrazoConlusao(LocalDate prazoConclusao) {
		this.prazoConclusao = prazoConclusao;
	}



	public Status getStatus() {
		return status;
	}



	public void setStatus(Status status) {
		this.status = status;
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
	
	public Boolean getEmAtraso() { 		
		LocalDate hoje = LocalDate.now(); 		
		if (hoje.isBefore(prazoConclusao)) { 			
			return true; 		
			} 		
		return false; 	
		}
	

}
	