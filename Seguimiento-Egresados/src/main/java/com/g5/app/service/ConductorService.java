package com.g5.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g5.app.model.Conductor;
import com.g5.app.repository.ConductorRepository;

@Service
public class ConductorService {
	
	@Autowired
	private ConductorRepository conductorRepository;
	
	public Conductor CreateOrUpdate(Conductor conductor) {
		return conductorRepository.save(conductor);
	}
	
	public List<Conductor> getAllConductors(){
		return conductorRepository.findAll();
	}
	
	public void delete (Conductor conductor) {
		conductorRepository.delete(conductor);
	}
	
	public Conductor findById(Long dni){
		return conductorRepository.findById(dni).get();
	}

}
