package com.carla.os.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carla.os.domain.OS;

public interface OSRepository extends JpaRepository< OS , Integer> {

}
