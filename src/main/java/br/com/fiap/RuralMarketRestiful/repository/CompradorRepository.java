package br.com.fiap.RuralMarketRestiful.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.fiap.RuralMarketRestiful.model.Comprador;



@Repository
public interface CompradorRepository extends JpaRepository<Comprador, Integer> {
	@Query("SELECT u.email FROM Comprador u")
	List<String> findAllEmails();
	List<Comprador> findByEmail(String email);
}
