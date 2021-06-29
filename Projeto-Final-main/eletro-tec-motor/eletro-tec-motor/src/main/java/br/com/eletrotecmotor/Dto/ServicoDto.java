package br.com.eletrotecmotor.Dto;

import java.util.Date;

import org.springframework.data.domain.Page;

import br.com.eletrotecmotor.modelo.Servico;
import br.com.eletrotecmotor.modelo.Status;

public class ServicoDto {
	
	private long id;
	private String nomeProduto;
	private String marca;
	private String descricaoObjeto;
	private String descricaoServico;
	private String dadosAdicionais;
	private Date dataEntrada;
	private Date prazoConclusao;
	private double valorEstimado;
	private Status status;
	private String prioridade;
	private String numeroOrdem;
	
	
	public ServicoDto(Servico servico) {

	this.id = servico.getId();
	this.nomeProduto = servico.getNomeProduto();
	this.marca =servico.getMarca();
	this.descricaoObjeto = servico.getDescricaoObjeto();
	this.dadosAdicionais = servico.getDadosAdicionais();
	this.dataEntrada = servico.getDataEntrada();
	this.prazoConclusao =servico.getPrazoConclusao();
	this.valorEstimado = servico.getValorEstimado();
	this.status = servico.getStatus();
	this.numeroOrdem = servico.getNumeroOrdem();
	
	
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
	
	public String getMarca() {
		return marca;
	}
	
	public String getDescricaoObjeto() {
		return descricaoObjeto;
	}
	
	public String getDescricaoServico() {
		return descricaoServico;
	}
	
	public String getDadosAdicionais() {
		return dadosAdicionais;
	}
	
	public Date getDataEntrada() {
		return dataEntrada;
	}
	
	public Date getPrazoConclusao() {
		return prazoConclusao;
	}
	
	public double getValorEstimado() {
		return valorEstimado;
	}
	
	public Status getStatus() {
		return status;
	}
	
	public String getPrioridade() {
		return prioridade;
	}
	
	public String getNumeroOrdem() {
		return numeroOrdem;
	}
	
	
	public static Page<ServicoDto> converter(Page<Servico> servico) {
		
		return servico.map(ServicoDto::new);
		
	}

}
