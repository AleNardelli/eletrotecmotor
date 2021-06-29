package br.com.eletrotecmotor.form;

import br.com.eletrotecmotor.modelo.Cliente;
import br.com.eletrotecmotor.repository.ClienteRepository;

public class AtualizacaoClienteForm {

	public Cliente atualizar(Long id, ClienteRepository clienteRepository) {
		Cliente  cliente = clienteRepository.getOne(id);
		return cliente;
	}

}
