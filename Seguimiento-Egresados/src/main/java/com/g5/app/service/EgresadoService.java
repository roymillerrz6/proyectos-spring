package com.g5.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g5.app.model.Egresado;
import com.g5.app.repository.EgresadoRepository;

@Service
public class EgresadoService {
	
	@Autowired
	private EgresadoRepository egresadoRepository;
	
	public EgresadoService(EgresadoRepository egresadoRepository) {
		this.egresadoRepository = egresadoRepository;
	}

	public Egresado create(Egresado egresado) {
		return egresadoRepository.save(egresado);
	}
	
	public List<Egresado> getAllEgresados(){
		return egresadoRepository.findAll();
	}
	
	public void delete (Egresado egresado) {
		egresadoRepository.delete(egresado);
	}
	
	public Optional<Egresado> findById(Long idEgresado){
		return egresadoRepository.findById(idEgresado);
	}
	


}
