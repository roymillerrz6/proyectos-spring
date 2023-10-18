package com.g5.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g5.app.model.Cargo;

import com.g5.app.repository.CargoRepository;

@Service
public class CargoService {
	
	@Autowired
	private CargoRepository cargoRepository;
	
	public Cargo create(Cargo cargo) {
		return cargoRepository.save(cargo);
	}
	
	public void delete (Cargo cargo) {
		cargoRepository.delete(cargo);
	}

	public Optional<Cargo> findById(Long Id){
		return cargoRepository.findById(Id);
	}
	

}
