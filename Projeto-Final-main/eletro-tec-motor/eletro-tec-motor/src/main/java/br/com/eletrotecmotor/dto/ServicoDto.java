package br.com.eletrotecmotor.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.eletrotecmotor.modelo.Pecas;
import br.com.eletrotecmotor.dto.PecasDto;
import br.com.eletrotecmotor.modelo.Servico;

public class ServicoDto {
	
	private List<PecasDto> pecasDto = new ArrayList<>();
	private double total;
	private LocalDate dataEntrada;
	
	
		public ServicoDto(Servico servico) {
			this.pecasDto = PecasDto.conversao(servico.getPecas());
			this.total = servico.getTotal();
			this.dataEntrada = servico.getDataEntrada();
			}
	


	public List<PecasDto> getPecas() {
		return pecasDto;
	}
	
	public double getTotal() {
		return total;
	}
	
	public LocalDate getDataEntrada() {
		return dataEntrada;
	}



	public static ServicoDto conversao(Servico servico) {
		ServicoDto dto = new ServicoDto(servico);
		return dto;
	}
	
	public static List<ServicoDto> conversao(List<Servico> servico){
		return servico.stream().map(z->conversao(z)).collect(Collectors.toList());
		}
	
// 	public static ServicoDto conversao(Servico servico) {
//	ServicoDto dto = new ServicoDto();
//	PecasDto dtoPecas = new PecasDto();
//	dto.setPecas(dtoPecas.conversao(servico.getPecas()));
//	dto.setTotal(servico.getTotal());
//	dto.setData(servico.getDataEntrada());
//	return dto;
//}
	

}
