package br.com.fiap.RuralMarketRestiful.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.RuralMarketRestiful.model.Anuncio;
import br.com.fiap.RuralMarketRestiful.model.Modalidade;
import br.com.fiap.RuralMarketRestiful.model.Usuario;


@Repository
public interface AnuncioRepository extends JpaRepository<Anuncio, Integer> {

	List<Anuncio> findByModalidade(Modalidade modalidade);
	List<Anuncio> findByUsuario(Usuario usuario);
	Page<Anuncio> findByValorBetween(Double minValor, Double maxValor, Pageable pageable);
	Page<Anuncio> findByValorGreaterThan(Double minValor, Pageable pageable);
	Page<Anuncio> findByValorLessThan(Double maxValor, Pageable pageable);
	//	Page<Anuncio> findByTituloContainingIgnoreCase(String titulo, Pageable pageable);
}

