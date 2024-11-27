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

import br.com.fiap.RuralMarketRestiful.model.Comprador;
import br.com.fiap.RuralMarketRestiful.model.Usuario;
import br.com.fiap.RuralMarketRestiful.repository.CompradorRepository;
import jakarta.transaction.Transactional;


@RestController
@RequestMapping("comprador")
public class CompradorResource {
	@Autowired
	private CompradorRepository compradorRepository;
	
	Usuario usuario = new Usuario();
	
	
	@GetMapping
	public List<Comprador> listar() {
		return compradorRepository.findAll();
	}

	@GetMapping("/page")
	public ResponseEntity<Page<Comprador>> findAll(Pageable pageable) {
		Page<Comprador> result = compradorRepository.findAll(pageable);
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("{codigo}")
	public Comprador buscar(@PathVariable int codigo) {
		return compradorRepository.findById(codigo).get();
	}
	

	
	@GetMapping("/email")
	public List<Comprador> findByEmail(@RequestParam String email) {
	    return compradorRepository.findByEmail(email);
	}
	
	@GetMapping("/emails")
	public List<String> findAllEmails() {
	    return compradorRepository.findAllEmails();
	}
	
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping
	@Transactional
	public Comprador cadastrar(@RequestBody Comprador comprador) {
		return compradorRepository.save(comprador);
	}
	
	@Transactional
	@PutMapping("{id}")
	public Comprador atualizar(@RequestBody Comprador comprador, @PathVariable long id) {
		comprador.setId(id);
		return compradorRepository.save(comprador);
	}
	
	@Transactional
	@DeleteMapping("{codigo}")
	public void remover(@PathVariable int codigo) {
		compradorRepository.deleteById(codigo);
	}

}