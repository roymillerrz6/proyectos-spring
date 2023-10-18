package com.g5.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MensajeUsuarioID implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "idUsuario")
	private Long idUsuario;
	
	@Column(name = "idMensaje_Reporte")
	private Long idMensajeReporte;
}
