package com.g5.app.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="software_producto")
public class SoftwareProducto {

	@Id
	@Column(name = "idSoftwareProducto")
	private Long idSoftwareProducto;
	
	@Column(length = 30, name = "metodologia_producto")
	private String metodologiaProducto;
	
	@Column(length = 30, name = "nombre_proyecto")
	private String NombreProyecto;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaInicio;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCierre;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idEgresado")
	private Egresado egresado;
	
	public SoftwareProducto(Long idSoftwareProducto, String metodologiaProducto, String nombreProyecto,
			Date fechaInicio, Date fechaCierre, Date fechaPublicacion, Egresado egreado) {
		super();
		this.idSoftwareProducto = idSoftwareProducto;
		this.metodologiaProducto = metodologiaProducto;
		NombreProyecto = nombreProyecto;
		this.fechaInicio = fechaInicio;
		this.fechaCierre = fechaCierre;
		this.egresado = egreado;
	}

	
	public Egresado getEgresado() {
		return egresado;
	}

	public void setEgresado(Egresado egresado) {
		this.egresado = egresado;
	}

	public Long getIdSoftwareProducto() {
		return idSoftwareProducto;
	}

	public void setIdSoftwareProducto(Long idSoftwareProducto) {
		this.idSoftwareProducto = idSoftwareProducto;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaCierre() {
		return fechaCierre;
	}

	public void setFechaCierre(Date fechaCierre) {
		this.fechaCierre = fechaCierre;
	}

	public String getMetodologiaProducto() {
		return metodologiaProducto;
	}

	public void setMetodologiaProducto(String metodologiaProducto) {
		this.metodologiaProducto = metodologiaProducto;
	}

	public String getNombreProyecto() {
		return NombreProyecto;
	}

	public void setNombreProyecto(String nombreProyecto) {
		NombreProyecto = nombreProyecto;
	}


	public SoftwareProducto () {
		
	}
	

	
}
