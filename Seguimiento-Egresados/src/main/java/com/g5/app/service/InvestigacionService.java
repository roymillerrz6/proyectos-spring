package com.g5.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g5.app.model.Investigacion;
import com.g5.app.model.SoftwareProducto;
import com.g5.app.repository.InvestigacionRepository;

@Service
public class InvestigacionService {
	
	@Autowired
	private InvestigacionRepository investigacionRepository;
	
	@Autowired
	private EgresadoService egresadoService;
	
	public Investigacion Create(Investigacion rl, Long idusuario) {
		
		//Buscar objeto Egresado para completar Objeto RcimientoLaboral = insertar campo idusuario!
	//	rl.setEgresado(egresadoService.findById(idusuario).get());
		return investigacionRepository.save(rl);
	}
	
	public Investigacion Update(Investigacion rl) {
		return investigacionRepository.save(rl);
	}
	
	public void delete (Investigacion rl) {
		investigacionRepository.delete(rl);
	}
	
	public List<Investigacion> getAllInvestigacionesByIdUsuario(Long idUsuario){
		return investigacionRepository.findByEgresadoIdUsuario(idUsuario);
	}
	
	public List<Investigacion> getAllInvestigacions(){
		return investigacionRepository.findAll();
	}
	
	public Optional<Investigacion> findById(Long Id){
		return investigacionRepository.findById(Id);
	}

}
