package br.com.gvendas.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gvendas.entidades.Produto;
import br.com.gvendas.respositorio.ProdutoRepositorio;

@Service
public class ProdutoServico {
	@Autowired
	private ProdutoRepositorio produtoRepositorio;
	
	public List <Produto> listarTodos() {
		return produtoRepositorio.findAll();
	}
	
	
	
}
