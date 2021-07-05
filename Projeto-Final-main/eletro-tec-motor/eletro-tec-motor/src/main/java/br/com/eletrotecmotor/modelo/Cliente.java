package br.com.eletrotecmotor.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	private Long id;
	private String nome;
	@Column(unique = true)
	private String cpf;
	private String telefone;
	private String email;
	private String estado;
	private String cidade;
	private String bairro;
	private String rua;
	private String cep;
	private String complemento;
	


	public Cliente() {

	}
	
	


	public Cliente(Long id, String nome, String cpf, String telefone, String email, String estado, String cidade,
		String bairro, String rua, String cep, String complemento) {
	this.id = id;
	this.nome = nome;
	this.cpf = cpf;
	this.telefone = telefone;
	this.email = email;
	this.estado = estado;
	this.cidade = cidade;
	this.bairro = bairro;
	this.rua = rua;
	this.cep = cep;
	this.complemento = complemento;
}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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




	public Object converter(List<Cliente> findList) {
		return null;
	}






}
