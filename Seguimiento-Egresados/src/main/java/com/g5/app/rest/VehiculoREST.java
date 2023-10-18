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

import com.g5.app.model.Vehiculo;
import com.g5.app.service.VehiculoService;

@RestController
@RequestMapping("/log/vehiculo/")
public class VehiculoREST {
	
	@Autowired
	private VehiculoService vehiculoService;
	
	@PostMapping (
	//		consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}, 
      //      produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
	)
	private ResponseEntity<Vehiculo> Crear (@RequestBody Vehiculo rl){
		Vehiculo temporal = vehiculoService.CreateOrUpdate(rl);
		try {
			return ResponseEntity.created(new URI("/log/vehiculo/"+temporal.getIdVehiculo())).body(temporal);
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	
	@GetMapping()
	private ResponseEntity<List<Vehiculo>> Listar(){
		return ResponseEntity.ok(vehiculoService.getAllVehiculos());
	}
	 
	
	@RequestMapping(value = "{id}",method = RequestMethod.DELETE)
	private ResponseEntity<Void> eliminar(@PathVariable Long id){
		vehiculoService.delete(vehiculoService.findById(id));
		return ResponseEntity.ok().build();
	}


}
