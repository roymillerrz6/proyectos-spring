package com.g5.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.g5.app.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	Usuario findByDni(String dni);
	
 
	Optional<Usuario> findOneByDni(String dni);
	
/*	@Query("""
			Select u.dni, u.password  from Usuario u inner join Token t on u.idUsuario = t.Usuario.getIdUsuario()
			where u.idUsuario = :id and t.refreshToken = :refreshToken and t.expiration >= :expiredAt
			"""
			)
	Usuario findIdUsuarioAndTokensRefreshTokenAndTokensExpiredAtGreaterThan(Long id, String refreshToken, LocalDateTime expiredAt); */
	
}
