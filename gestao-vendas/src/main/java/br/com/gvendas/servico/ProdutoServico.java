package br.com.gvendas.servico;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.gvendas.entidades.Produto;
import br.com.gvendas.respositorio.ProdutoRepositorio;

@Service
public class ProdutoServico {
	
	@Autowired
	private ProdutoRepositorio produtoRepositorio;
	
	public List <Produto> listarTodos() {
		return produtoRepositorio.findAll();
	}

	public Optional<Produto> listaPorCodigo (@PathVariable Long codigoProduto, @PathVariable Long codigoCategoria  ) {
		return produtoRepositorio.buscarPorCodigo(codigoProduto, codigoCategoria); 
	}
	
	public void salvar() {
		
	}
	
}
