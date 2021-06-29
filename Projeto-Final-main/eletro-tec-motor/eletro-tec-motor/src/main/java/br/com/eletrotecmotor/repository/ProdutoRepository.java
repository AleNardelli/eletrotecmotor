package br.com.eletrotecmotor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.eletrotecmotor.modelo.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	Produto findBynome(String nome);

}
