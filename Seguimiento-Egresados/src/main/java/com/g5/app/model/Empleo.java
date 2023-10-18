package com.g5.app.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="empleo")
public class Empleo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "idEmpleo")
    private Long idEmpleo;

    @Column
    private String NombreEmpresa;

    @Column
    private String areaTrabajo;

    @Column
    private String Direccion;

    @Column
    private String rubro;

    @Column
    private float sueldo;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Column(name = "fechaContrato")
    private Date fechaContrato;

    public Empleo() {
    }

    public Long getIdEmpleo() {
        return idEmpleo;
    }

    public void setIdEmpleo(Long idEmpleo) {
        this.idEmpleo = idEmpleo;
    }

    public String getAreaTrabajo() {
        return areaTrabajo;
    }

    public void setAreaTrabajo(String areaTrabajo) {
        this.areaTrabajo = areaTrabajo;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getRubro() {
        return rubro;
    }

    public void setRubro(String rubro) {
        this.rubro = rubro;
    }

    public float getSueldo() {
        return sueldo;
    }

    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }

    public Date getFechaContrato() {
        return fechaContrato;
    }

    public void setFechaContrato(Date fechaContrato) {
        this.fechaContrato = fechaContrato;
    }
}
