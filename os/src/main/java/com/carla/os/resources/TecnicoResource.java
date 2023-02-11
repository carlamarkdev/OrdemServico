package com.carla.os.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carla.os.dtos.TecnicoDTO;
import com.carla.os.services.TecnicoService;

@RestController
@RequestMapping(value = "/tecnicos")
public class TecnicoResource {

	@Autowired
	private TecnicoService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<TecnicoDTO> findById(@PathVariable Integer id) {
		TecnicoDTO objDTO = new TecnicoDTO(service.findById(id));
		return ResponseEntity.ok().body(objDTO);

	}

	@GetMapping
	public ResponseEntity<List<TecnicoDTO>> findAll() {

		List<TecnicoDTO> listDTO = service.findAll().stream().map(obj -> new TecnicoDTO(obj))
				.collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDTO);
		/*
		 * List<Tecnico> list = service.findAll(); List<TecnicoDTO> listDTO = new
		 * ArrayList<>();
		 * 
		 * for(Tecnico obj : list) { listDTO.add(new TecnicoDTO(obj)); }
		 * 
		 * list.forEach(obj -> listDTO.add(new TecnicoDTO(obj)));
		 */
	}

}
