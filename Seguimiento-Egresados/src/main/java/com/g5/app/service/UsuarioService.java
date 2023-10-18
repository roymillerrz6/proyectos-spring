package com.g5.app.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g5.app.model.Usuario;
import com.g5.app.repository.UsuarioRepository;


@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
/*	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;*/
	

	public Usuario CreateOrUpdate(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public List<Usuario> getAllUsuarios(){
		return usuarioRepository.findAll();
	}
	
	public void delete (Usuario usuario) {
		usuarioRepository.delete(usuario);
	}
	
	public Usuario findByDni(String dni){
		return usuarioRepository.findByDni(dni);
	}
	

	
// ----------------------------------------- A PARTIR DE AQUI HAY OTRA LOGICA PARA TOKENS ------------------------------
 /*	public Usuario findByDniOrCodigoEstudiante(String usuario,String password) {
		
		Usuario usuarioConfirmado=usuarioRepository.findByDni(usuario);		
		if(usuarioConfirmado == null) {
			Egresado egresadoConfirmado = egresadoRepository.findByCodigoEstudiante(usuario);
			if(egresadoConfirmado != null) {
			 Optional<Usuario> usuarioEncontrado = usuarioRepository.findById(egresadoConfirmado.getIdUsuario());
			   if(usuarioEncontrado.isPresent() && bCryptPasswordEncoder.matches(password, usuarioEncontrado.get().getPassword()) == true) {
				   
				   return usuarioEncontrado.get(); 
				   
			   }else 
				return null;
			
			}else {
				return null;
			}
		}else {
			if(bCryptPasswordEncoder.matches(password, usuarioConfirmado.getPassword())){
				//return usuarioConfirmado;
				return usuarioConfirmado;
			}else {
				return null;
			}
		}*/

	}
	
	

	
