package br.unisul.web.sexta.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.unisul.web.sexta.domain.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer > {

	List<Categoria> findByNomeContaining(String nome);

}
