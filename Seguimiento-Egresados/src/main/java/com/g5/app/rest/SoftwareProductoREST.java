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

import com.g5.app.model.SoftwareProducto;
import com.g5.app.service.SoftwareProductoService;

@RestController
@RequestMapping("/api/softwares/")
public class SoftwareProductoREST {
	
	@Autowired
	private SoftwareProductoService softwareProductoService;
	
	@PostMapping (value = "{idusuario}" 
	)
	private ResponseEntity<SoftwareProducto> Crear (@RequestBody SoftwareProducto rl,@PathVariable Long idusuario){
		SoftwareProducto temporal = softwareProductoService.Create(rl,idusuario);
		try {
			return ResponseEntity.created(new URI("/api/reconocimientos/"+temporal.getIdSoftwareProducto())).body(temporal);
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	private ResponseEntity<SoftwareProducto> Actualizar (@RequestBody SoftwareProducto rl){
		
		SoftwareProducto temporal = softwareProductoService.Update(rl);
		return ResponseEntity.ok(temporal);
	}
	
	
	@GetMapping(value = "{id}")
	private ResponseEntity<List<SoftwareProducto>> ListarReconocimientos (@PathVariable ("id") Long id){
		return ResponseEntity.ok(softwareProductoService.getAllSoftwaresByIdEgresado(id));
	}
	
	@GetMapping()
	private ResponseEntity<List<SoftwareProducto>> ListarReconocimientos (){
		return ResponseEntity.ok(softwareProductoService.getAllSoftwares());
	}
	 
	
	@RequestMapping(value = "{id}",method = RequestMethod.DELETE)
	private ResponseEntity<Void> eliminarReconocimiento(@PathVariable Long id){
		softwareProductoService.delete(softwareProductoService.findById(id).get());
		return ResponseEntity.ok().build();
	}
	
  	@GetMapping(value = "{id}/{idusuario}")
	private ResponseEntity<Optional<SoftwareProducto>> buscar(@PathVariable ("id") Long id,@PathVariable ("idusuario") Long idusuario){
		return ResponseEntity.ok(softwareProductoService.findById(id));
	}


}
