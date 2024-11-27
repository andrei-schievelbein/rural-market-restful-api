package br.com.fiap.RuralMarketRestiful.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.RuralMarketRestiful.model.Anuncio;
import br.com.fiap.RuralMarketRestiful.model.Modalidade;
import br.com.fiap.RuralMarketRestiful.repository.AnuncioRepository;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("anuncio")
public class AnuncioResource {
	@Autowired
	private AnuncioRepository anuncioRepository;
	
	//http://localhost:8080/anuncio
	@GetMapping
	public List<Anuncio> listar() {
		return anuncioRepository.findAll();
	}

	@GetMapping(value = "/page")
	public ResponseEntity<Page<Anuncio>> findAll(Pageable pageable) {
		Page<Anuncio> result = anuncioRepository.findAll(pageable);
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("{codigo}")
	public Anuncio buscar(@PathVariable int codigo) {
		return anuncioRepository.findById(codigo).get();
	}

	@GetMapping("/modalidade")
	public List<Anuncio> buscarPorModalidade(@RequestParam("modalidade") Modalidade modalidade) {
		return anuncioRepository.findByModalidade(modalidade);
	}
	
	@GetMapping("/valor")
	public ResponseEntity<Page<Anuncio>> searchByValorBetween(@RequestParam(defaultValue = "0") Double minValor, @RequestParam(defaultValue = "1000000000000") Double maxValor, Pageable pageable) {
	    Page<Anuncio> result = anuncioRepository.findByValorBetween(minValor, maxValor, pageable);
	    return ResponseEntity.ok(result);
	}
	
	@GetMapping("/valoracima")
	public ResponseEntity<Page<Anuncio>> findByValorGreaterThan(@RequestParam(defaultValue = "0") Double minValor, Pageable pageable) {
	    Page<Anuncio> result = anuncioRepository.findByValorGreaterThan(minValor, pageable);
	    return ResponseEntity.ok(result);
	}
	
	@GetMapping("/valorabaixo")
	public ResponseEntity<Page<Anuncio>> findByValorLessThan(@RequestParam(defaultValue = "1000000000000") Double maxValor, Pageable pageable) {
	    Page<Anuncio> result = anuncioRepository.findByValorLessThan(maxValor, pageable);
	    return ResponseEntity.ok(result);
	}
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping
	@Transactional
	public Anuncio cadastrar(@RequestBody Anuncio anuncio) {
		return anuncioRepository.save(anuncio);
	}
	
	@Transactional
	@PutMapping("{id}")
	public Anuncio atualizar(@RequestBody Anuncio anuncio, @PathVariable long id) {
		anuncio.setId(id);
		return anuncioRepository.save(anuncio);
	}
	
	@Transactional
	@DeleteMapping("{codigo}")
	public void remover(@PathVariable int codigo) {
		anuncioRepository.deleteById(codigo);
	}
}