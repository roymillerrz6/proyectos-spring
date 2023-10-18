package com.g5.app.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "egresado")
public class Egresado implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idUsuario")
	private Long idUsuario;
	
	@OneToOne
	@MapsId
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;	
		
	@Column(length = 60)
	private String Direccion;
	
	@Column(length = 30, name = "ApePaterno")
	private String ApePaterno;
	
	@Column(length = 30, name = "ApeMaterno")
	private String ApeMaterno;
	
	@Column(length = 60, name = "NombreCompleto")
	private String NomCompleto;
	
	@Column(length = 10, name = "CodigoEstudiante")
	private String codigoEstudiante;
	

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name = "AñoIngreso")
	private Date AñoIngreso;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name = "AñoEgreso")
	private Date AñoEgreso;

	
	public Egresado() {}


	public Egresado(Long idUsuario, Usuario usuario, String direccion, String apePaterno, String apeMaterno,
			String codigoEstudiante, Date añoIngreso, Date añoEgreso) {
		this.idUsuario = idUsuario;
		this.usuario = usuario;
		Direccion = direccion;
		ApePaterno = apePaterno;
		ApeMaterno = apeMaterno;
		this.codigoEstudiante = codigoEstudiante;
		AñoIngreso = añoIngreso;
		AñoEgreso = añoEgreso;
	}


	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
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

	public String getCodigoEstudiante() {
		return codigoEstudiante;
	}

	public void setCodigoEstudiante(String codigoEstudiante) {
		this.codigoEstudiante = codigoEstudiante;
	}

	public Date getAñoIngreso() {
		return AñoIngreso;
	}

	public void setAñoIngreso(Date añoIngreso) {
		AñoIngreso = añoIngreso;
	}

	public Date getAñoEgreso() {
		return AñoEgreso;
	}

	public void setAñoEgreso(Date añoEgreso) {
		AñoEgreso = añoEgreso;
	}


	
	
}
