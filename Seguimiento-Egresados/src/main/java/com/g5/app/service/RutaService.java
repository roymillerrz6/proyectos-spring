package com.g5.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g5.app.model.Ruta;
import com.g5.app.repository.RutaRepository;

@Service
public class RutaService {

	@Autowired
	private RutaRepository rutaRepository;
	
	public Ruta CreateOrUpdate(Ruta ruta) {
		return rutaRepository.save(ruta);
	}
	
	public List<Ruta> getAllRutas(){
		return rutaRepository.findAll();
	}
	
	public void delete (Ruta ruta) {
		rutaRepository.delete(ruta);
	}
	
	public Ruta findById(Long dni){
		return rutaRepository.findById(dni).get();
	}
	
}
