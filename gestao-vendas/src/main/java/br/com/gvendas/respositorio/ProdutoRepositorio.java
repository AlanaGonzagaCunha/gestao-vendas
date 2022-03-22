package br.com.gvendas.respositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gvendas.entidades.Produto;

public interface ProdutoRepositorio extends JpaRepository<Produto, Long>{

}
