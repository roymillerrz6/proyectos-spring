package com.g5.app.rest;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.g5.app.model.Empleado;
import com.g5.app.service.EmpleadoService;

@RestController
@CrossOrigin
@RequestMapping("/api/empleado/")
public class EmpleadoREST {

	@Autowired
	private EmpleadoService empleadoService;
	
	@PostMapping
	private ResponseEntity<Empleado> guardar (@RequestBody Empleado empleado){
		Empleado temporal = empleadoService.create(empleado);
		try {
			return ResponseEntity.created(new URI("/api/empleado/"+temporal.getIdEmpleado())).body(temporal);
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	

	@DeleteMapping
	private ResponseEntity<Void> eliminarEmpleado(@RequestBody Empleado empleado){
		empleadoService.delete(empleado);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping(value = "{id}")
	private ResponseEntity<Optional<Empleado>> buscar(@PathVariable ("id") Long id){
		return ResponseEntity.ok(empleadoService.findById(id));
	}
	
}
