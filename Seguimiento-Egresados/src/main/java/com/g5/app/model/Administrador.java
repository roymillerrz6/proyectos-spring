package com.g5.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "administrador")
public class Administrador implements Serializable{

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
	
	@Column(length = 30, name = "ApePaterno")
	private String ApePaterno;
	
	@Column(length = 30, name = "ApeMaterno")
	private String ApeMaterno;
	
    public Administrador() {}
	
	public Administrador(Long idUsuario, Usuario usuario, String apePaterno, String apeMaterno) {
		super();
		this.idUsuario = idUsuario;
		this.usuario = usuario;
		ApePaterno = apePaterno;
		ApeMaterno = apeMaterno;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
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


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
