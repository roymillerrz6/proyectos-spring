package com.g5.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.g5.app.model.Usuario;
import com.g5.app.repository.UsuarioRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String dni) throws UsernameNotFoundException {
		
		Usuario usuario =  usuarioRepository
				.findOneByDni(dni)
				.orElseThrow(() -> new UsernameNotFoundException("El usuario con DNI: "+dni+" no existe"));

		return new UserDetailsImpl(usuario);
	}

}
