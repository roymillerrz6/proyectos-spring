package com.g5.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "mensaje_usuario")
public class MensajeUsuario {

	@EmbeddedId
	private MensajeUsuarioID mensajeUsuarioID;
	
	@MapsId("idUsuario")
	@JoinColumn(name = "idusuario", referencedColumnName = "idUsuario")
	@ManyToOne
	private Usuario usuario;
	
	@MapsId("idMensajeReporte")
	@JoinColumn(name = "idMensajereporte", referencedColumnName = "idMensajeReporte")
	@ManyToOne
	private MensajeReporte mensajeReporte;
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern="yyyy-MM-dd HH::mm:ss.SSS")
	@Column(name = "FechaRespuesta")
	private Date FechaRespuesta;
	
	@Column(length = 900)
	private String MensajeRespuesta;
}
