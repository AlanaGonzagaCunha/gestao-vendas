package br.com.gvendas.respositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gvendas.entidades.Categoria;

public interface CategoriaRepositorio extends JpaRepository <Categoria, Long> {
	Categoria findByNameCategoria(String nome);

}
