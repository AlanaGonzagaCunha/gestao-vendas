package br.com.gvendas.controlador;

import java.util.List;
import java.util.Optional;

import javax.annotation.Generated;
import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.gvendas.entidades.Categoria;
import br.com.gvendas.servico.CategoriaServico;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(tags = "Categoria")
@RestController
@RequestMapping("/categoria")
public class CategoriaControlador {
	
	@Autowired
	private CategoriaServico categoriaServico;
	
	@ApiOperation(value = "Listar")
	@GetMapping
	public List<Categoria> listarTodas() {
		return categoriaServico.listarTodas();
	}
	
	@ApiOperation(value = "Listar por Código")
	@GetMapping("/{codigo}")
	public ResponseEntity <Optional<Categoria>> listarPorId(@PathVariable Long codigo) {
		Optional<Categoria> categoria = categoriaServico.buscarPorCodigo(codigo);
		
		return categoria.isPresent() ? ResponseEntity.ok(categoria) : ResponseEntity.notFound().build();
	}
	
	@ApiOperation(value = "Salvar")
	@PostMapping
	public ResponseEntity<Categoria> salvar (@RequestBody Categoria categoria) {
		
		Categoria categoriaSalva = categoriaServico.salvar(categoria);
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaSalva);
	}
	
	@ApiOperation(value = "Atualizar")
	@PutMapping("/{codigo}")
	public ResponseEntity<Categoria> atualizar (@PathVariable Long codigo, @Valid @RequestBody Categoria categoria){
		return ResponseEntity.ok(categoriaServico.atualizar(codigo, categoria));
	}
	
	@ApiOperation(value = "Deletear")
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long codigo) {
		categoriaServico.deletar(codigo);
	}
}
