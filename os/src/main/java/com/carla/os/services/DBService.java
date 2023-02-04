
package com.carla.os.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carla.os.domain.Cliente;
import com.carla.os.domain.OS;
import com.carla.os.domain.Tecnico;
import com.carla.os.domain.enuns.Prioridade;
import com.carla.os.domain.enuns.Status;
import com.carla.os.repositories.ClienteRepository;
import com.carla.os.repositories.OSRepository;
import com.carla.os.repositories.TecnicoRepository;

@Service
public class DBService {

	@Autowired
	private TecnicoRepository tecnicoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private OSRepository osRepository;

	public void instaciaDB() {
		Tecnico t1 = new Tecnico(null, "valdir", "102.308.600-01", "(88) 98888-8888");
		Cliente c1 = new Cliente(null, "Betina", "698.849.010-82", "(88) 98888-8888");
		OS os1 = new OS(null, Prioridade.ALTA, "teste ", Status.ANDAMENTO, t1, c1);

		t1.getList().add(os1);
		c1.getList().add(os1);

		tecnicoRepository.saveAll(Arrays.asList(t1));
		clienteRepository.saveAll(Arrays.asList(c1));
		osRepository.saveAll(Arrays.asList(os1));
	}

}
