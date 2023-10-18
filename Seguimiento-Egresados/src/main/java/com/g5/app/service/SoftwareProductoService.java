package com.g5.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g5.app.model.ReconocimientoLaboral;
import com.g5.app.model.SoftwareProducto;
import com.g5.app.repository.ReconocimientoLaboralRepository;
import com.g5.app.repository.SoftwareProductoRepository;

@Service
public class SoftwareProductoService {
	
	@Autowired
	private SoftwareProductoRepository softwareProductoRepository;
	
	@Autowired
	private EgresadoService egresadoService;
	
	public SoftwareProducto Create(SoftwareProducto sp, Long idusuario) {
		
		//Buscar objeto Egresado para completar Objeto RcimientoLaboral = insertar campo idusuario!
		sp.setEgresado(egresadoService.findById(idusuario).get());
		return softwareProductoRepository.save(sp);
	}
	
	public SoftwareProducto Update(SoftwareProducto sp) {
		return softwareProductoRepository.save(sp);
	}
	
	public void delete (SoftwareProducto sp) {
		softwareProductoRepository.delete(sp);
	}
	
	public List<SoftwareProducto> getAllSoftwaresByIdEgresado(Long idUsuario){
		return softwareProductoRepository.findByEgresadoIdUsuario(idUsuario);
	}
	
	public List<SoftwareProducto> getAllSoftwares(){
		return softwareProductoRepository.findAll();
	}
	
	public Optional<SoftwareProducto> findById(Long Id){
		return softwareProductoRepository.findById(Id);
	}

}
