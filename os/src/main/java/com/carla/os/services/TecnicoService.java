package com.carla.os.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carla.os.domain.Tecnico;
import com.carla.os.dtos.TecnicoDTO;
import com.carla.os.repositories.TecnicoRepository;
import com.carla.os.services.exeptions.DataIntegratyViolationException;
import com.carla.os.services.exeptions.ObjectNotFoundException;

@Service
public class TecnicoService {

	@Autowired
	private TecnicoRepository repository;

	public Tecnico findById(Integer id) {
		Optional<Tecnico> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto Não Encontrado! ID: " + id + ", Tipo :" + Tecnico.class.getName()));

	}

	public List<Tecnico> findAll() {
		return repository.findAll();
	}

	public Tecnico create(TecnicoDTO objDTO) {
		if (findByCPF(objDTO) != null) {
			throw new DataIntegratyViolationException("CPF Já cadastrado na base de dados!");
		}
		
		
		return repository.save(new Tecnico(null, objDTO.getNome(), objDTO.getCpf(), objDTO.getTelefone()));

	}

	private Tecnico findByCPF(TecnicoDTO obDto) {
		Tecnico obj = repository.findByCPF(obDto.getCpf());
		if (obj != null) {
			return obj;
		}

		return null;

	}

}
