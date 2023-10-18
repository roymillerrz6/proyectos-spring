package com.g5.app.rest;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.g5.app.model.Usuario;
import com.g5.app.service.UsuarioService;

@RestController
@CrossOrigin()
@RequestMapping("/api/usuario/")
public class UsuarioREST {

	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping
	private ResponseEntity<Usuario> guardar (@RequestBody Usuario usuario){
		Usuario temporal = usuarioService.CreateOrUpdate(usuario);
		try {
			return ResponseEntity.created(new URI("/api/usuario"+temporal.getIdUsuario())).body(temporal);
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	
	@GetMapping("lista")
	private ResponseEntity<List<Usuario>> ListarUsuarios (){
		return ResponseEntity.ok(usuarioService.getAllUsuarios());
	}
	
	//@DeleteMapping(value= {"dni"})
	@RequestMapping(value= {"dni"}, method = RequestMethod.DELETE)
	private ResponseEntity<Void> eliminarUsuario(@PathVariable ("dni") String dni){
		usuarioService.delete(usuarioService.findByDni(dni));
		return ResponseEntity.ok().build();
	}
	
	@GetMapping(value = "{dni}")
	private ResponseEntity<Usuario> buscarUsuario (@PathVariable ("dni") String dni){
		return ResponseEntity.ok(usuarioService.findByDni(dni));
	}
	
	
	/* @PostMapping("login")
	public ResponseEntity<Usuario> login(@RequestBody Usuario usuario) {

		Usuario loginUsuario= usuarioService.findByDniOrCodigoEstudiante(usuario.getDNI(), usuario.getPassword());
		try {
			return ResponseEntity.ok(loginUsuario);
		} catch (Exception e) {
			return null;
		}
		
	}*/
	
	record UserResponse(Long id, String dni) {}
	
	@GetMapping("usuario")
	public UserResponse usuario(HttpServletRequest request) {
		Usuario usuario = (Usuario)request.getAttribute("usuario");
		
		return new UserResponse(usuario.getIdUsuario(),usuario.getDNI());
	}
	

	
	
}
