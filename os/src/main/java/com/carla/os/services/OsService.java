package com.carla.os.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carla.os.domain.Cliente;
import com.carla.os.domain.OS;
import com.carla.os.domain.Tecnico;
import com.carla.os.domain.enuns.Prioridade;
import com.carla.os.domain.enuns.Status;
import com.carla.os.dtos.OSDTO;
import com.carla.os.repositories.OSRepository;
import com.carla.os.services.exeptions.ObjectNotFoundException;

@Service
public class OsService {
	
	@Autowired
	private OSRepository repository;
	
	@Autowired
	private TecnicoService tecnicoService;
	
	@Autowired
	private ClienteService clienteService;
	
	public OS findById(Integer id) {
		Optional<OS> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! "+ id +", Tipo: "+ OS.class.getName()));
	}
	
	public List<OS> findAll(){
		return repository.findAll();
	}

	public OS create(@Valid OSDTO obj) {
		return fromDTO(obj);
	}
	
	private OS fromDTO(OSDTO obj) {
		OS newObj = new OS();
		newObj.setId(obj.getId());
		newObj.setObservacoes(obj.getObservacoes());
		newObj.setPrioridade(Prioridade.toEnum(obj.getPrioridade()));
		newObj.setStatus(Status.toEnum(obj.getStatus()));
		
		Tecnico tec = tecnicoService.findById(obj.getTecnico());
		Cliente cli = clienteService.findById(obj.getCliente());
		
		newObj.setTecnico(tec);
		newObj.setCliente(cli);
		
		return repository.save(newObj);
	}

}
