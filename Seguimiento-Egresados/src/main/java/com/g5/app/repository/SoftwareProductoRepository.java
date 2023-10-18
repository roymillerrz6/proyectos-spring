package com.g5.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.g5.app.model.SoftwareProducto;

@Repository
public interface SoftwareProductoRepository extends JpaRepository<SoftwareProducto, Long>{

	Optional<SoftwareProducto> findById(Long id);
	
	/*@Modifying
	@Query(
			" Select e.* from ReconocimientoLaboral e where e.idUsuario = :idUsuario"
			)*/
	List<SoftwareProducto> findByEgresadoIdUsuario(Long idUsuario);
	
}
