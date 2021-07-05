package br.com.eletrotecmotor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.eletrotecmotor.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Long>{

}
