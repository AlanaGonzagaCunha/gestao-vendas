package br.com.gvendas.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gvendas.entidades.Categoria;
import br.com.gvendas.excecao.EmptyResultDataAcessException;
import br.com.gvendas.respositorio.CategoriaRepositorio;

@Service
public class CategoriaServico {
	@Autowired
	private CategoriaRepositorio categoriaRepositorio;
	
	public List	 <Categoria> listarTodas() {
		return categoriaRepositorio.findAll();
	}
	
	public Optional<Categoria> buscarPorCodigo (Long codigo) {
		return categoriaRepositorio.findById(codigo);
	}
	
	public Categoria salvar(Categoria categoria) {
		validarCategoriaDuplicada(categoria);
		return categoriaRepositorio.save(categoria);
	}
	
	public Categoria atualizar(Long codigo, Categoria categoria) {
		Categoria categoriaSalva = validarCategoriaExiste(codigo);
		validarCategoriaDuplicada(categoria);
		BeanUtils.copyProperties(categoria, categoriaSalva, "codigo");
		return categoriaRepositorio.save(categoriaSalva);
	}
	
	public void deletar(Long codigo) {
		categoriaRepositorio.deleteById(codigo);
	}
	
	public void validarCategoriaDuplicada(Categoria categoria) {
		
	}
	
	public Categoria validarCategoriaExiste(Long codigo) {
		Optional<Categoria> categoria = buscarPorCodigo(codigo);
		
		if(categoria.isEmpty()) {
			throw new EmptyResultDataAcessException(1);
		}
		return categoria.get();
	}
	
}
