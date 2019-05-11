package br.unisul.web.sexta.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.unisul.web.sexta.config.dtos.CategoriaDto;
import br.unisul.web.sexta.domain.Categoria;
import br.unisul.web.sexta.services.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

	@Autowired
	private CategoriaService service;

	// BUSCAR POR ID
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Categoria> find(@PathVariable Integer id) {
		Categoria obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Categoria obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Categoria obj, @PathVariable Integer id) {
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}

	// EXCLUIR
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	// LISTAR TODAS
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<CategoriaDto>> findAll() {
		List<Categoria> lista = service.findAll();

		List<CategoriaDto> listDto = new ArrayList<CategoriaDto>();

		for (Categoria c : lista) {
			listDto.add(new CategoriaDto(c));
		}

		return ResponseEntity.ok().body(listDto);
	}

	// LISTAR POR NOME

	@RequestMapping(value = "/filtro/{nome}", method = RequestMethod.GET)
	public ResponseEntity<List<CategoriaDto>> get(@PathVariable String nome) {

		List<Categoria> lista = service.listarPorNome(nome);

		List<CategoriaDto> listDto = new ArrayList<CategoriaDto>();

		for (Categoria c : lista) {
			listDto.add(new CategoriaDto(c));
		}

		return ResponseEntity.ok().body(listDto);
	}

}
