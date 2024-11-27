package br.com.fiap.RuralMarketRestiful.controller;

import java.util.List;

import br.com.fiap.RuralMarketRestiful.model.Comprador;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.fiap.RuralMarketRestiful.model.Usuario;
import br.com.fiap.RuralMarketRestiful.repository.UsuarioRepository;



@RestController
@RequestMapping("usuario")
public class UsuarioResource {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	Usuario usuario = new Usuario();
	
	
	@GetMapping
	public List<Usuario> listar() {
		return usuarioRepository.findAll();
	}

	@GetMapping(value = "/page")
	public ResponseEntity<Page<Usuario>> findAll(Pageable pageable) {
		Page<Usuario> result = usuarioRepository.findAll(pageable);
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("{codigo}")
	public Usuario buscar(@PathVariable int codigo) {
		return usuarioRepository.findById(codigo).get();
	}
	

	
	@GetMapping("/email")
	public List<Usuario> findByEmail(@RequestParam String email) {
	    return usuarioRepository.findByEmail(email);
	}
	
	@GetMapping("/emails")
	public List<String> findAllEmails() {
	    return usuarioRepository.findAllEmails();
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping
	@Transactional
	public Usuario cadastrar(@RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@Transactional
	@PutMapping("{id}")
	public Usuario atualizar(@RequestBody Usuario usuario, @PathVariable long id) {
		usuario.setId(id);
		return usuarioRepository.save(usuario);
	}

	@Transactional
	@DeleteMapping("{codigo}")
	public void remover(@PathVariable int codigo) {
		usuarioRepository.deleteById(codigo);
	}

}