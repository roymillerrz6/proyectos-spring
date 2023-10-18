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

import com.g5.app.model.Cargo;

import com.g5.app.service.CargoService;


@RestController
@CrossOrigin
@RequestMapping("/api/cargo/")
public class CargoREST {


	@Autowired
	private CargoService cargoService;
	
	@PostMapping
	private ResponseEntity<Cargo> guardar (@RequestBody Cargo cargo){
		Cargo temporal = cargoService.create(cargo);
		try {
			return ResponseEntity.created(new URI("/api/cargo/"+temporal.getIdCargo())).body(temporal);
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	

	@DeleteMapping
	private ResponseEntity<Void> eliminarEmpleado(@RequestBody Cargo cargo){
		cargoService.delete(cargo);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping(value = "{id}")
	private ResponseEntity<Optional<Cargo>> buscar(@PathVariable ("id") Long id){
	return ResponseEntity.ok(cargoService.findById(id));
	}
	
	
}
