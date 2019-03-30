package br.unisul.web.sexta.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.web.sexta.domain.Categoria;
import br.unisul.web.sexta.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository rep;

	// BUSCA POR ID
	public Categoria find(Integer id) {
		Optional<Categoria> obj = rep.findById(id);
		return obj.orElse(null);
	}

	// FAZ INSERÇÃO
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return rep.save(obj);
	}

	// ATUALIZAR
	public Categoria update(Categoria obj) {
		find(obj.getId());
		return rep.save(obj);
	}

	// DELETAR
	public void delete(Integer id) {
		find(id);
		rep.deleteById(id);
	}

	// LISTAR TODAS
	public List<Categoria> findAll() {
		return rep.findAll();
	}
}
