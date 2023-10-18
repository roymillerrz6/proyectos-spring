package com.g5.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.g5.app.model.Administrativo;

@Repository
public interface AdministrativoRepository extends JpaRepository<Administrativo, Long>{
	

}
