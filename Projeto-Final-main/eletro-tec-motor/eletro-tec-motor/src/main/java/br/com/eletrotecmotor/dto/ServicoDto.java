package br.com.eletrotecmotor.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.eletrotecmotor.modelo.Pecas;
import br.com.eletrotecmotor.dto.PecasDto;
import br.com.eletrotecmotor.modelo.Servico;

public class ServicoDto {
	
	private List<PecasDto> Pecas;
	private double total;
	private LocalDateTime dataEntrada;
	
	public List<PecasDto> getPecas() {
		return Pecas;
	}
	public void setPecas(List<PecasDto> pecas) {
		Pecas = pecas;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public LocalDateTime getDataEntrada() {
		return dataEntrada;
	}
	public void setData(LocalDateTime dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	
	
	 	public static ServicoDto conversao(Servico servico) {
		ServicoDto dto = new ServicoDto();
		PecasDto dtoPecas = new PecasDto();
		dto.setPecas(dtoPecas.conversao(servico.getPecas()));
		dto.setTotal(servico.getTotal());
		dto.setData(servico.getDataEntrada());
		return dto;
	}
	
	public static List<ServicoDto> conversao(List<Servico> servico){
		return servico.stream().map(z->conversao(z)).collect(Collectors.toList());
		}
	
	
	

}
