package br.com.eletrotecmotor.form;

import java.util.Date;

import br.com.eletrotecmotor.modelo.Servico;
import br.com.eletrotecmotor.repository.ServicoRepository;

public class ServicoForm {
	
	private String nomeProduto;
	private String marca;
	private String descricaoObjeto;
	private String descricaoServico;
	private String dadosAdicionais;
	private Date dataEntrada;
	private Date prazoConclusao;
	private double valorEstimado;
	private String status;
	private String prioridade;
	private String numeroOrdem;
	
	

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



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
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



	public Servico converter(ServicoRepository servicoRepository) {
		
		return new Servico(0, nomeProduto, marca, descricaoObjeto, descricaoServico,
				dadosAdicionais, dataEntrada, prazoConclusao, valorEstimado, null, prioridade, numeroOrdem);
	}


}
