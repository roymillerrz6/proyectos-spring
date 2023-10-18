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

import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "usuario")
public class Usuario {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idUsuario;
	
	@JsonIgnore
	@OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Egresado egresado;
	
	@JsonIgnore
	@OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Administrador administrador;
	
	@JsonIgnore
	@OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Administrativo administrativo;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createAt;
	
	@Column(length = 100)
	private String password;

	@ManyToOne
	@JoinColumn(name = "idRol")
	private Rol rol;
	
	@Column(length = 8)
	private String dni;
	
	@Column(length = 30)
	private String estado;
	
	

	public Usuario(Long idUsuario, Egresado egresado, Administrador administrador, Administrativo administrativo,
			Date createAt, String password, Rol rol, String dni, String estado) {
		this.idUsuario = idUsuario;
		this.egresado = egresado;
		this.administrador = administrador;
		this.administrativo = administrativo;
		this.createAt = createAt;
		this.password = password;
		this.rol = rol;
		this.dni = dni;
		this.estado = estado;
	}

	public Usuario() {
		this.estado="ACTIVO";
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Egresado getEgresado() {
		return egresado;
	}

	public void setEgresado(Egresado egresado) {
		this.egresado = egresado;
	}

	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}

	public Administrativo getAdministrativo() {
		return administrativo;
	}

	public void setAdministrativo(Administrativo administrativo) {
		this.administrativo = administrativo;
	}

	public String getDNI() {
		return dni;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}


	
}
