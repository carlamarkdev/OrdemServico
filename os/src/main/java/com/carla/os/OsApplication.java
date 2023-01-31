package com.carla.os;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.carla.os.domain.Cliente;
import com.carla.os.domain.OS;
import com.carla.os.domain.Tecnico;
import com.carla.os.domain.enuns.Prioridade;
import com.carla.os.domain.enuns.Status;
import com.carla.os.repositories.ClienteRepository;
import com.carla.os.repositories.OSRepository;
import com.carla.os.repositories.TecnicoRepository;

@SpringBootApplication
public class OsApplication implements CommandLineRunner{
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private OSRepository osRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(OsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Tecnico t1 = new Tecnico(null,"valdir","144.785.300-84","(88) 98888-8888");
		Cliente c1 = new Cliente(null,"Betina","",null);
		OS os1 = new OS(null,Prioridade.ALTA,"teste ",Status.ANDAMENTO,t1,c1);
		
		t1.getList().add(os1);
		c1.getList().add(os1);
		
		tecnicoRepository.saveAll(Arrays.asList(t1));
		clienteRepository.saveAll(Arrays.asList(c1));
		osRepository.saveAll(Arrays.asList(os1));
		
	}

}
