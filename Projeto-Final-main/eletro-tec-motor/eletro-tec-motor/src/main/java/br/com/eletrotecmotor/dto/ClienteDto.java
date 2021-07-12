package br.com.eletrotecmotor.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CNPJ;
import org.springframework.format.annotation.NumberFormat;

import br.com.eletrotecmotor.modelo.Cliente;

public class ClienteDto {

	@NotBlank
	private String nome;
	@NumberFormat
	private String cpf;
	@CNPJ @Column(unique = true)
	private String cnpj;
	@NotBlank
	private String telefone;
	@Email
	private String email;

	public ClienteDto(Cliente cliente) {
		this.nome = cliente.getNome();
		this.cpf = cliente.getCpf();
		this.cnpj= cliente.getCnpj();
		this.email = cliente.getEmail();
		this.telefone = cliente.getTelefone();
	}

	public String getNome() {
		return nome;
	}


	public String getCpf() {
		return cpf;
	}


	public String getCnpj() {
		return cnpj;
	}


	public String getTelefone() {
		return telefone;
	}


	public String getEmail() {
		return email;
	}
}
