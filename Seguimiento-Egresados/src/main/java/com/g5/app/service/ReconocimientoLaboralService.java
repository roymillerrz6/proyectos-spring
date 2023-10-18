 package com.g5.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g5.app.model.ReconocimientoLaboral;
import com.g5.app.repository.ReconocimientoLaboralRepository;

@Service
public class ReconocimientoLaboralService {
	
	@Autowired
	private ReconocimientoLaboralRepository reconocimientoLaboralRepository;
	
	@Autowired
	private EgresadoService egresadoService;
	
	public ReconocimientoLaboral Create(ReconocimientoLaboral rl, Long idusuario) {
		
		//Buscar objeto Egresado para completar Objeto RcimientoLaboral = insertar campo idusuario!
		rl.setEgresado(egresadoService.findById(idusuario).get());
		return reconocimientoLaboralRepository.save(rl);
	}
	
	public ReconocimientoLaboral Update(ReconocimientoLaboral rl) {
		return reconocimientoLaboralRepository.save(rl);
	}
	
	public void delete (ReconocimientoLaboral rl) {
		reconocimientoLaboralRepository.delete(rl);
	}
	
	public List<ReconocimientoLaboral> getAllReconocimientosByIdUsuario(Long idUsuario){
		return reconocimientoLaboralRepository.findByEgresadoIdUsuario(idUsuario);
	}
	
	public List<ReconocimientoLaboral> getAllReconocimientos(){
		return reconocimientoLaboralRepository.findAll();
	}
	
	public Optional<ReconocimientoLaboral> findById(Long Id){
		return reconocimientoLaboralRepository.findById(Id);
	}

}
