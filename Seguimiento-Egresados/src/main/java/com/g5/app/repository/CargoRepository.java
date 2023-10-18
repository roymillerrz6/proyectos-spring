package com.g5.app.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.g5.app.model.Cargo;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long>{

	Optional<Cargo> findById(Long id);
	
}
