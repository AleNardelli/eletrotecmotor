package br.com.eletrotecmotor.form;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.eletrotecmotor.modelo.Cliente;
import br.com.eletrotecmotor.modelo.Pecas;
import br.com.eletrotecmotor.modelo.Servico;
import br.com.eletrotecmotor.repository.ClienteRepository;
import br.com.eletrotecmotor.repository.PecasRepository;
import br.com.eletrotecmotor.repository.ServicoRepository;

public class ServicoForm {
	
	private String descricaoServico;
	private LocalDate prazoConclusao;
	private double maoDeObra;
	private Long idcliente;
	private List<Long> idpecas;
	
	public String getDescricaoServico() {
		return descricaoServico;
	}

	public void setDescricaoServico(String descricaoServico) {
		this.descricaoServico = descricaoServico;
	}

	public LocalDate getPrazoConclusao() {
		return prazoConclusao;
	}

	public void setPrazoConclusao(LocalDate prazoConclusao) {
		this.prazoConclusao = prazoConclusao;
	}

	public Long getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(Long idcliente) {
		this.idcliente = idcliente;
	}

	public List<Long> getIdpecas() {
		return idpecas;
	}

	public void setIdpecas(List<Long> idpecas) {
		this.idpecas = idpecas;
	}
	
	

	public double getMaoDeObra() {
		return maoDeObra;
	}

	public void setMaoDeObra(double maoDeObra) {
		this.maoDeObra = maoDeObra;
	}

	public Servico converter(ClienteRepository CR, ServicoRepository SR, PecasRepository PR) {
		
		LocalDateTime dataEntrada = LocalDateTime.now();
		
		double total = 0.0; 
		Cliente cliente = CR.getById(idcliente);
		List<Pecas> listaDePecas = new ArrayList<>();
		for (Long idp : idpecas) {
			Pecas pecas = PR.getById(idp);
			total += pecas.getPrecoUnitario();
			listaDePecas.add(pecas);
		}
		
		 total += maoDeObra;
		
		
		Servico servico = new Servico(descricaoServico, dataEntrada, prazoConclusao, total, cliente, listaDePecas);
		SR.save(servico);
		return servico;
	}
	
	

}
