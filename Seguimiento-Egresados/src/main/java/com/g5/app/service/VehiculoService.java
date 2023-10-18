package com.g5.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g5.app.model.Vehiculo;
import com.g5.app.repository.VehiculoRepository;

@Service
public class VehiculoService {
	
	@Autowired
	private VehiculoRepository vehiculoRepository;
	
	public Vehiculo CreateOrUpdate(Vehiculo vehiculo) {
		return vehiculoRepository.save(vehiculo);
	}
	
	public List<Vehiculo> getAllVehiculos(){
		return vehiculoRepository.findAll();
	}
	
	public void delete (Vehiculo vehiculo) {
		vehiculoRepository.delete(vehiculo);
	}
	
	public Vehiculo findById(Long dni){
		return vehiculoRepository.findById(dni).get();
	}

}
