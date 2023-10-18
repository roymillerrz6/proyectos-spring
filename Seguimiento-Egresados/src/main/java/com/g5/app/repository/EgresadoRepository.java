package com.g5.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.g5.app.model.Egresado;

@Repository
public interface EgresadoRepository extends JpaRepository<Egresado, Long> {
	
	Egresado findByCodigoEstudiante(String CodigoEstudiante);
}
