package br.com.eletrotecmotor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.eletrotecmotor.modelo.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Long> {

}
