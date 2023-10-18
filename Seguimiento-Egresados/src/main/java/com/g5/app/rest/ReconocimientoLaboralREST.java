package com.g5.app.rest;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//import com.g5.app.model.Conductor;
import com.g5.app.model.ReconocimientoLaboral;
//import com.g5.app.service.ConductorService;
import com.g5.app.service.ReconocimientoLaboralService;

@RestController
@RequestMapping("/api/reconocimientos/")
public class ReconocimientoLaboralREST {

	@Autowired
	private ReconocimientoLaboralService reconocimientoLaboralService;
	
	@PostMapping (value = "{idusuario}" 
	)
	private ResponseEntity<ReconocimientoLaboral> Crear (@RequestBody ReconocimientoLaboral rl,@PathVariable Long idusuario){
		ReconocimientoLaboral temporal = reconocimientoLaboralService.Create(rl,idusuario);
		try {
			return ResponseEntity.created(new URI("/api/reconocimientos/"+temporal.getIdReconocimientolaboral())).body(temporal);
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	private ResponseEntity<ReconocimientoLaboral> Actualizar (@RequestBody ReconocimientoLaboral rl){
		
		System.out.println(rl.getIdReconocimientolaboral());
		ReconocimientoLaboral temporal = reconocimientoLaboralService.Update(rl);
		return ResponseEntity.ok(temporal);
	}
	
	
	@GetMapping(value = "{id}")
	private ResponseEntity<List<ReconocimientoLaboral>> ListarReconocimientos (@PathVariable ("id") Long id){
		return ResponseEntity.ok(reconocimientoLaboralService.getAllReconocimientosByIdUsuario(id));
	}
	 
	
	@RequestMapping(value = "{id}",method = RequestMethod.DELETE)
	private ResponseEntity<Void> eliminarReconocimiento(@PathVariable Long id){
		reconocimientoLaboralService.delete(reconocimientoLaboralService.findById(id).get());
		return ResponseEntity.ok().build();
	}
	
  	@GetMapping(value = "{id}/{idusuario}")
	private ResponseEntity<Optional<ReconocimientoLaboral>> buscar(@PathVariable ("id") Long id,@PathVariable ("idusuario") Long idusuario){
		return ResponseEntity.ok(reconocimientoLaboralService.findById(id));
	}



}
