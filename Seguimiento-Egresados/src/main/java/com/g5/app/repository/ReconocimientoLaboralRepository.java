package com.g5.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.g5.app.model.ReconocimientoLaboral;

@Repository
public interface ReconocimientoLaboralRepository extends JpaRepository<ReconocimientoLaboral, Long> {

	Optional<ReconocimientoLaboral> findById(Long id);
	
	/*@Modifying
	@Query(
			" Select e.* from ReconocimientoLaboral e where e.idUsuario = :idUsuario"
			)*/
	List<ReconocimientoLaboral> findByEgresadoIdUsuario(Long idUsuario);

}
