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
@Table(name = "mensaje_reporte")
public class MensajeReporte {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idMensajeReporte;
	
	@Column(length = 30)
	private String asunto;
	
	@Column(length = 60)
	private String Descripcion;
	
	@Column(name = "EstadoReporte", length = 500)
	private String EstadoReporte;
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern="yyyy-MM-dd HH::mm:ss.SSS")
	@Column(name = "FechaReporte")
	private Date FechaReporte;
	
}
