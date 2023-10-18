package com.g5.app.rest;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.g5.app.model.Investigacion;
import com.g5.app.service.InvestigacionService;

@RestController
@RequestMapping("/api/investigaciones/")
public class InvestigacionREST {
	
	@Autowired
	private InvestigacionService investigacionService;
	
	@PostMapping (value = "{idusuario}" 
	)
	private ResponseEntity<Investigacion> Crear (@RequestBody Investigacion rl,@PathVariable Long idusuario){
		Investigacion temporal = investigacionService.Create(rl,idusuario);
		try {
			return ResponseEntity.created(new URI("/api/reconocimientos/"+temporal.getIdInvestigacion())).body(temporal);
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	private ResponseEntity<Investigacion> Actualizar (@RequestBody Investigacion rl){
		
		Investigacion temporal = investigacionService.Update(rl);
		return ResponseEntity.ok(temporal);
	}
	
	
	@GetMapping(value = "{id}")
	private ResponseEntity<List<Investigacion>> ListarReconocimientos (@PathVariable ("id") Long id){
		return ResponseEntity.ok(investigacionService.getAllInvestigacionesByIdUsuario(id));
	}
	
	@GetMapping()
	private ResponseEntity<List<Investigacion>> ListarReconocimientos (){
		return ResponseEntity.ok(investigacionService.getAllInvestigacions());
	}
	 
	
	@RequestMapping(value = "{id}",method = RequestMethod.DELETE)
	private ResponseEntity<Void> eliminarReconocimiento(@PathVariable Long id){
		investigacionService.delete(investigacionService.findById(id).get());
		return ResponseEntity.ok().build();
	}
	
  	@GetMapping(value = "{id}/{idusuario}")
	private ResponseEntity<Optional<Investigacion>> buscar(@PathVariable ("id") Long id,@PathVariable ("idusuario") Long idusuario){
		return ResponseEntity.ok(investigacionService.findById(id));
	}



}
