package br.com.gvendas.controlador;

import java.util.List;
import java.util.Optional;

import javax.annotation.Generated;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gvendas.entidades.Categoria;
import br.com.gvendas.servico.CategoriaServico;

@RestController
@RequestMapping("/categoria")
public class CategoriaControlador {
	
	@Autowired
	private CategoriaServico categoriaServico;
	
	@GetMapping
	public List<Categoria> listarTodas() {
		return categoriaServico.listarTodas();
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity <Optional<Categoria>> listarPorId(@PathVariable Long codigo) {
		Optional<Categoria> categoria = categoriaServico.listar(codigo);
		
		return categoria.isPresent() ? ResponseEntity.ok(categoria) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Categoria> salvar (@RequestBody Categoria categoria) {
		
		Categoria categoriaSalva = categoriaServico.salvar(categoria);
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaSalva);
	}
}
