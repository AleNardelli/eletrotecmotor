package br.com.eletrotecmotor.form;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CNPJ;
import org.springframework.format.annotation.NumberFormat;

import br.com.eletrotecmotor.modelo.Cliente;

public class ClienteForm {
	
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


	public void setNome(String nome) {
		this.nome = nome;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Cliente converter() {
		return new Cliente(nome,cpf,cnpj,telefone,email);
	}

}