package br.com.gvendas.respositorio;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.gvendas.entidades.Produto;

@Repository
public interface ProdutoRepositorio extends JpaRepository <Produto, Long>{
	
	List <Produto> findByCategoriaCodigo(Long codigoCategoria);
	
	@Query("Select prod"
			+ " from Produto prod"
			+ " where prod.codigo = :codigo"
			+ "   and prod.categoria.codigo = :codigoCategoria")
	Optional <Produto> buscarPorCodigo(Long codigo, Long codigoCategoria);
	
	Optional <Produto> findByCategoriaCodigoAndDescricao(Long codigoCategoria, String descricao);
	
	void deleteByCodigoAndCategoriaCodigo(Long codigoProduto, Long codigoCategoria);
}
