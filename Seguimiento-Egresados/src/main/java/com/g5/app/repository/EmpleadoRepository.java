package com.g5.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.g5.app.model.Empleado;


@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long>{

	Optional<Empleado> findById(Long id);
	
}
