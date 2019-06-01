package br.unisul.web.sexta.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.web.sexta.domain.Cidade;
import br.unisul.web.sexta.repositories.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository rep;
	
	
	@Autowired
	private EstadoService estadoService;

	public List<Cidade> findByEstado(Integer estadoId){
		return rep.findCidades(estadoId);
	}
	
	public Cidade insert(Cidade obj) {
		obj.setId(null);
		obj.setEstado(estadoService.find(obj.getEstado().getId()));
		obj = rep.save(obj);
		return obj;
	}
	
	//LISTAR TODAS
	public List<Cidade> findAll(){
		return rep.findAll();
	}

	public List<Cidade> findByEstado(Integer estadoId) {
		return rep.findCidades(estadoId);
	}
}