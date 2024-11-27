package br.com.fiap.RuralMarketRestiful.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.fiap.RuralMarketRestiful.model.Usuario;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {


	@Query("SELECT u.email FROM Usuario u")
	List<String> findAllEmails();
	List<Usuario> findByEmail(String email);


	
}
