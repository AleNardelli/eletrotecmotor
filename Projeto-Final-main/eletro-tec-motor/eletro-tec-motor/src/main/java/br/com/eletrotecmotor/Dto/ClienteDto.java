package br.com.eletrotecmotor.Dto;

import org.springframework.data.domain.Page;

import br.com.eletrotecmotor.modelo.Cliente;

public class ClienteDto {

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

	public String getCpf() {
		return cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getEmail() {
		return email;
	}

	public String getEstado() {
		return estado;
	}

	public String getCidade() {
		return cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public String getRua() {
		return rua;
	}

	public String getCep() {
		return cep;
	}

	public String getComplemento() {
		return complemento;
	}

	public ClienteDto(Cliente cliente) {

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

	public static Page<ClienteDto> coventer(Page<Cliente> cliente) {

		return cliente.map(ClienteDto::new);

	}

}
