package br.com.gvendas.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gvendas.entidades.Categoria;
import br.com.gvendas.respositorio.CategoriaRepositorio;

@Service
public class CategoriaServico {
	@Autowired
	private CategoriaRepositorio categoriaRepositorio;
	
	public List	 <Categoria> listarTodas() {
		return categoriaRepositorio.findAll();
	}
	
	public Optional<Categoria> listar (Long codigo) {
		return categoriaRepositorio.findById(codigo);
	}
	
	public Categoria salvar(Categoria categoria) {
		return categoriaRepositorio.save(categoria);
	}
	
}
