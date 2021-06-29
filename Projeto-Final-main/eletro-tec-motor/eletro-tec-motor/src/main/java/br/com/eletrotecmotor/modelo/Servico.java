package br.com.eletrotecmotor.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Servico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "nomeproduto")
	private String nomeProduto;
	@Column(name = "marca")
	private String marca;
	@Column(name = "descricaoObjeto")
	private String descricaoObjeto;
	@Column(name = "descricaoServico")
	private String descricaoServico;
	@Column(name = "dadosadicionais")
	private String dadosAdicionais;
	@Column(name = "dataEntrada")
	private Date dataEntrada;
	@Column(name = "prazoConclusao")
	private Date prazoConclusao;
	@Column(name = "valorEstimado")
	private double valorEstimado;
	@Column(name = "status")
	private Status status = Status.Aberto;
	@Column(name = "prioridade")
	private String prioridade;
	@Column(name = "numeroOrdem")
	private String numeroOrdem;
	
	public Servico() {
		
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public Date getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(Date dataEntrada) {
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
	
	
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
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
	
	public Servico(long id, String nomeProduto, String marca, String descricaoObjeto, String descricaoServico,
			String dadosAdicionais, Date dataEntrada, Date prazoConclusao, double valorEstimado, Status status,
			String prioridade, String numeroOrdem) {
		
		this.id = id;
		this.nomeProduto = nomeProduto;
		this.marca = marca;
		this.descricaoObjeto = descricaoObjeto;
		this.descricaoServico = descricaoServico;
		this.dadosAdicionais = dadosAdicionais;
		this.dataEntrada = dataEntrada;
		this.prazoConclusao = prazoConclusao;
		this.valorEstimado = valorEstimado;
		this.status = status;
		this.prioridade = prioridade;
		this.numeroOrdem = numeroOrdem;
	}
	
	
	
}
