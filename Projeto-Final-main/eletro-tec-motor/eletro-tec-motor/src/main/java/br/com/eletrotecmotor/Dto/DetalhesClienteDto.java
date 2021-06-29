package br.com.eletrotecmotor.Dto;

import br.com.eletrotecmotor.modelo.Cliente;

public class DetalhesClienteDto {
	
	private String nome;
	private String cpf;
	private String telefone;
	private String email;
	private String estado;
	private String cidade;
	private String bairro;
	private String rua;
	private String cep;
	private String complemento;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public DetalhesClienteDto(Cliente cliente) {
		
		this.nome = cliente.getNome();
		this.cpf = cliente.getCpf();
		this.telefone = cliente.getTelefone();
		this.email = cliente.getEmail();
		this.estado = cliente.getEstado();
		this.cidade = cliente.getCidade();
		this.bairro = cliente.getBairro();
		this.rua = cliente.getRua();
		this.cep = cliente.getCep();
		this.complemento = cliente.getComplemento();
		
		
	}
	
	

}
