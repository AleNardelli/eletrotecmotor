package br.com.eletrotecmotor.modelo;

import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Servico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_servico")
	private Long id;
	private String nomeProduto;
	private String marca;
	private String descricaoObjeto;
	private String descricaoServico;
	private String dadosAdicionais;
	private String dataEntrada;
	private Date prazoConclusao;
	private double valorEstimado; //valor estimado é o valor total = peças + mão de obra
	private String prioridade;
	private String numeroOrdem;
	
	public Servico() {
		
	}
	
	public Servico(Long id, String nomeProduto, String marca, String descricaoObjeto, String descricaoServico,
			String dadosAdicionais, String dataEntrada, Date prazoConclusao, double valorEstimado, String prioridade,
			String numeroOrdem) {
		super();
		this.id = id;
		this.nomeProduto = nomeProduto;
		this.marca = marca;
		this.descricaoObjeto = descricaoObjeto;
		this.descricaoServico = descricaoServico;
		this.dadosAdicionais = dadosAdicionais;
		this.dataEntrada = dataEntrada;
		this.prazoConclusao = prazoConclusao;
		this.valorEstimado = valorEstimado;
		this.prioridade = prioridade;
		this.numeroOrdem = numeroOrdem;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getDescricaoObjeto() {
		return descricaoObjeto;
	}

	public void setDescricaoObjeto(String descricaoObjeto) {
		this.descricaoObjeto = descricaoObjeto;
	}

	public String getDescricaoServico() {
		return descricaoServico;
	}

	public void setDescricaoServico(String descricaoServico) {
		this.descricaoServico = descricaoServico;
	}

	public String getDadosAdicionais() {
		return dadosAdicionais;
	}

	public void setDadosAdicionais(String dadosAdicionais) {
		this.dadosAdicionais = dadosAdicionais;
	}

	
	public String getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(String dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public Date getPrazoConclusao() {
		return prazoConclusao;
	}

	public void setPrazoConclusao(Date prazoConclusao) {
		this.prazoConclusao = prazoConclusao;
	}

	public double getValorEstimado() {
		return valorEstimado;
	}

	public void setValorEstimado(double valorEstimado) {
		this.valorEstimado = valorEstimado;
	}

	public String getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}

	public String getNumeroOrdem() {
		return numeroOrdem;
	}

	public void setNumeroOrdem(String numeroOrdem) {
		this.numeroOrdem = numeroOrdem;
	}
	
	
	
	

}
