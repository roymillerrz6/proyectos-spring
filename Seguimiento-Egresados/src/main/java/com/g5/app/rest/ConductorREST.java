package com.g5.app.rest;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.g5.app.model.Conductor;
import com.g5.app.service.ConductorService;

@RestController
@CrossOrigin("*")
@RequestMapping("/log/conductor/")
public class ConductorREST {
	
	@Autowired
	private ConductorService conductorService;
	
	@PostMapping (
		consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE , MediaType.TEXT_PLAIN_VALUE}, 
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_PLAIN_VALUE}
	)
	private ResponseEntity<Conductor> Crear (@RequestBody Conductor rl){
		Conductor temporal = conductorService.CreateOrUpdate(rl);
		try {
			return ResponseEntity.created(new URI("/log/conductor/"+temporal.getIdConductor())).body(temporal);
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	
	@GetMapping()
	private ResponseEntity<List<Conductor>> ListarReconocimientos (){
		return ResponseEntity.ok(conductorService.getAllConductors());
	}
	 
	
	@RequestMapping(value = "{id}",method = RequestMethod.DELETE)
	private ResponseEntity<Void> eliminarReconocimiento(@PathVariable Long id){
		conductorService.delete(conductorService.findById(id));
		return ResponseEntity.ok().build();
	}


}
