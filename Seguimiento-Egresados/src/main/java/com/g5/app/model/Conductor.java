package com.g5.app.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "conductor")
public class Conductor {
	
	@Id
	@GeneratedValue ( strategy = GenerationType.IDENTITY)
	private Long idConductor;

	@Column(length = 60)
	private String Direccion;
	
	@Column(length = 30, name = "ApePaterno")
	private String ApePaterno;
	
	@Column(length = 30, name = "ApeMaterno")
	private String ApeMaterno;
	
	@Column(length = 60, name = "NombreCompleto")
	private String NomCompleto;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name = "AñoIngreso")
	private Date fechaIngreso;
	
	@Column(length = 60)
	private String estado;

	public Long getIdConductor() {
		return idConductor;
	}

	public void setIdConductor(Long idConductor) {
		this.idConductor = idConductor;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}

	public String getApePaterno() {
		return ApePaterno;
	}

	public void setApePaterno(String apePaterno) {
		ApePaterno = apePaterno;
	}

	public String getApeMaterno() {
		return ApeMaterno;
	}

	public void setApeMaterno(String apeMaterno) {
		ApeMaterno = apeMaterno;
	}

	public String getNomCompleto() {
		return NomCompleto;
	}

	public void setNomCompleto(String nomCompleto) {
		NomCompleto = nomCompleto;
	}



	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Conductor(Long idConductor, String direccion, String apePaterno, String apeMaterno, String nomCompleto,
			Date fechaIngreso, String estado) {
		super();
		this.idConductor = idConductor;
		Direccion = direccion;
		ApePaterno = apePaterno;
		ApeMaterno = apeMaterno;
		NomCompleto = nomCompleto;
		this.fechaIngreso = fechaIngreso;
		this.estado = estado;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}


	
	public Conductor () {		
	}
}
