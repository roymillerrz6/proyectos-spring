package com.g5.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "vehiculo")
public class Vehiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVehiculo;
	
	private int kilometrajeMaximo;
	
	private int LitrosTanque;
	
	@Column(length = 60)
	private String estado;
	
	@Column
	private String marca;
	
	@Column
	private String placa;
	
	@Column
	private float depreciacion;

	public Long getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(Long idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public int getKilometrajeMaximo() {
		return kilometrajeMaximo;
	}

	public void setKilometrajeMaximo(int kilometrajeMaximo) {
		this.kilometrajeMaximo = kilometrajeMaximo;
	}

	public int getLitrosTanque() {
		return LitrosTanque;
	}

	public void setLitrosTanque(int litrosTanque) {
		LitrosTanque = litrosTanque;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public float getDepreciacion() {
		return depreciacion;
	}

	public void setDepreciacion(float depreciacion) {
		this.depreciacion = depreciacion;
	}

	public Vehiculo(Long idVehiculo, int kilometrajeMaximo, int litrosTanque, String estado, String marca, String placa,
			float depreciacion) {
		super();
		this.idVehiculo = idVehiculo;
		this.kilometrajeMaximo = kilometrajeMaximo;
		LitrosTanque = litrosTanque;
		this.estado = estado;
		this.marca = marca;
		this.placa = placa;
		this.depreciacion = depreciacion;
	}
	
	public Vehiculo() {
	}
}
