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
@Table(name="investigacion")
public class Investigacion {
	
	
	@Id
	@Column(name = "idInvestigacion")
	private Long idInvestigacion;	
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaInicio;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCierre;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaPublicacion;
	
	@Column(length = 30, name = "metodologia_producto")
	private String metodologiaProducto;
	
	@Column(length = 30, name = "nombre_proyecto")
	private String NombreProyecto;
	
	@Column(length = 30, name = "motivo_desarrollo")
	private String MotivoDesarrollo;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idEgresado")
	private Egresado egresado;


	public Long getIdInvestigacion() {
		return idInvestigacion;
	}

	public void setIdInvestigacion(Long idInvestigacion) {
		this.idInvestigacion = idInvestigacion;
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

	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
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

	public String getMotivoDesarrollo() {
		return MotivoDesarrollo;
	}

	public void setMotivoDesarrollo(String motivoDesarrollo) {
		MotivoDesarrollo = motivoDesarrollo;
	}

	public Egresado getEgreado() {
		return egresado;
	}

	public void setEgreado(Egresado egreado) {
		this.egresado = egreado;
	}
	
	public Investigacion(Long idInvestigacion, Date fechaInicio, Date fechaCierre, Date fechaPublicacion,
			String metodologiaProducto, String nombreProyecto, String motivoDesarrollo, Egresado egreado) {
		this.idInvestigacion = idInvestigacion;
		this.fechaInicio = fechaInicio;
		this.fechaCierre = fechaCierre;
		this.fechaPublicacion = fechaPublicacion;
		this.metodologiaProducto = metodologiaProducto;
		NombreProyecto = nombreProyecto;
		MotivoDesarrollo = motivoDesarrollo;
		this.egresado = egreado;
	}

	public Investigacion() {
		
	}


}
