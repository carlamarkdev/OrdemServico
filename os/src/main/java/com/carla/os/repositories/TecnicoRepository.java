package com.carla.os.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carla.os.domain.Tecnico;

@Repository
public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {

}
