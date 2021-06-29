package br.com.eletrotecmotor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.eletrotecmotor.modelo.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {

}
