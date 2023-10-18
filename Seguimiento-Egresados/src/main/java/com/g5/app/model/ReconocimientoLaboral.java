package com.g5.app.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="reconocimiento_laboral")
public class ReconocimientoLaboral  {


	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "idReconocimientoLaboral")
	private Long idReconocimientolaboral;
	
	private String descripcion;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name = "FechaEmision")
	private Date FechaEmision;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idUsuario")
	private Egresado egresado;
	
	@Column(length = 30, name = "ApePaterno")
	private String ApePaterno;
	
	@Column(length = 30, name = "ApeMaterno")
	private String ApeMaterno;
	
	@Column(length = 60, name = "nombrecompleto")
	private String NomCompleto;
	
	@Column(length = 70)
	private String correo;
	
	@Column(length = 60)
	private String NombreCargo;
	
	@Column(length = 60)
	private String DescripcionCargo;
	
	@Column(length = 60)
	private String Area;


	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getArea() {
		return Area;
	}

	public void setArea(String area) {
		Area = area;
	}

	public Long getIdReconocimientolaboral() {
		return idReconocimientolaboral;
	}

	public void setIdReconocimientolaboral(Long idReconocimientolaboral) {
		this.idReconocimientolaboral = idReconocimientolaboral;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaEmision() {
		return FechaEmision;
	}

	public void setFechaEmision(Date fechaEmision) {
		FechaEmision = fechaEmision;
	}

	public Egresado getEgresado() {
		return egresado;
	}

	public void setEgresado(Egresado egresado) {
		this.egresado = egresado;
	}
	
	public Long idUsuario() {
		return this.egresado.getIdUsuario();
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

	public String getNombreCargo() {
		return NombreCargo;
	}

	public void setNombreCargo(String nombre) {
		NombreCargo = nombre;
	}

	public String getDescripcionCargo() {
		return DescripcionCargo;
	}

	public void setDescripcionCargo(String descripcionCargo) {
		DescripcionCargo = descripcionCargo;
	}
	
	public ReconocimientoLaboral() {}

	public String getNomCompleto() {
		return NomCompleto;
	}

	public void setNomCompleto(String nomCompleto) {
		NomCompleto = nomCompleto;
	}

	
}
