package com.g5.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g5.app.model.Empleado;
import com.g5.app.repository.EmpleadoRepository;

@Service
public class EmpleadoService {

	@Autowired
	private EmpleadoRepository empleadoRepository;
	
	public Empleado create(Empleado empleado) {
		return empleadoRepository.save(empleado);
	}
	
	public void delete (Empleado empleado) {
		empleadoRepository.delete(empleado);
	}
	
	public Optional<Empleado> findById(Long Id){
		return empleadoRepository.findById(Id);
	}
	
}
