package br.com.eletrotecmotor.repository;


import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.eletrotecmotor.modelo.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {

	Cliente findByNome(String nome);
	
	Cliente findByCpf(String cpf);
	
	List<Cliente> findClientesByNome(String nome);

	

}
