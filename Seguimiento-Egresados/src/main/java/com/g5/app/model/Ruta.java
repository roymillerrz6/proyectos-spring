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
@Table(name = "ruta")
public class Ruta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idruta;
	
	@Column
	private int kilometros;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaIda;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaVuelta;
	
	@Column(length = 100)
	private String descripcion;
	
	@Column
	private int tiempoEstimado;

	public Long getIdruta() {
		return idruta;
	}

	public void setIdruta(Long idruta) {
		this.idruta = idruta;
	}

	public int getKilometros() {
		return kilometros;
	}

	public void setKilometros(int kilometros) {
		this.kilometros = kilometros;
	}

	public Date getFechaIda() {
		return fechaIda;
	}

	public void setFechaIda(Date fechaIda) {
		this.fechaIda = fechaIda;
	}


	public Date getFechaVuelta() {
		return fechaVuelta;
	}

	public void setFechaVuelta(Date fechaVuelta) {
		this.fechaVuelta = fechaVuelta;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getTiempoEstimado() {
		return tiempoEstimado;
	}

	public void setTiempoEstimado(int tiempoEstimado) {
		this.tiempoEstimado = tiempoEstimado;
	}

	public Ruta(Long idruta, int kilometros, Date fechaIda, Date fechaVuelta, String descripcion,
			int tiempoEstimado) {
		super();
		this.idruta = idruta;
		this.kilometros = kilometros;
		this.fechaIda = fechaIda;
		this.fechaVuelta = fechaVuelta;
		this.descripcion = descripcion;
		this.tiempoEstimado = tiempoEstimado;
	}
	
	public Ruta() {
		
	}
}
