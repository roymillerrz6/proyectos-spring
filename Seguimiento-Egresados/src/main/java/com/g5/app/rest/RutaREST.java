package com.g5.app.rest;

import java.net.URI;
import java.util.List;

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

import com.g5.app.model.Ruta;
import com.g5.app.service.RutaService;


@RestController
@RequestMapping("/log/ruta/")
public class RutaREST {
	
	@Autowired
	private RutaService rutaService;
	
	@PostMapping (
	//		consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}, 
      //      produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
	)
	private ResponseEntity<Ruta> Crear (@RequestBody Ruta rl){
		Ruta temporal = rutaService.CreateOrUpdate(rl);
		try {
			return ResponseEntity.created(new URI("/log/ruta/"+temporal.getIdruta())).body(temporal);
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	
	@GetMapping()
	private ResponseEntity<List<Ruta>> Listar (){
		return ResponseEntity.ok(rutaService.getAllRutas());
	}
	 
	
	@RequestMapping(value = "{id}",method = RequestMethod.DELETE)
	private ResponseEntity<Void> eliminar(@PathVariable Long id){
		rutaService.delete(rutaService.findById(id));
		return ResponseEntity.ok().build();
	}

}
