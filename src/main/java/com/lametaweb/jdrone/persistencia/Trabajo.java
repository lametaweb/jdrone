package com.lametaweb.jdrone.persistencia;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

@Entity
public class Trabajo implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)	
	private Integer idTrabajo;
	
	@Basic(optional = false)
	private String numeroDeRegistro;
	@Temporal(TemporalType.TIMESTAMP)	
	private Date fechaHoraInicio;
	@Temporal(TemporalType.TIMESTAMP)	
	private Date fechaHoraFinalizacion;
	private Float velocidad;
	@Lob
	@Size(max = 65535)
	@Basic(fetch=FetchType.LAZY)
	private String descripcion;

	@JoinColumn (referencedColumnName = "iddrone")
    @ManyToOne
	private Drone droneAsignado;
	
	@OneToMany (cascade = CascadeType.ALL)
	@OrderColumn	
	private List<PuntoRuta> puntosDeRuta = new LinkedList<PuntoRuta>();
	
	public Integer getIdTrabajo() {
		return idTrabajo;
	}

	public void setIdTrabajo(Integer idTrabajo) {
		this.idTrabajo = idTrabajo;
	}

	public String getNumeroDeRegistro() {
		return numeroDeRegistro;
	}

	public void setNumeroDeRegistro(String numeroDeRegistro) {
		this.numeroDeRegistro = numeroDeRegistro;
	}

	public Date getFechaHoraInicio() {
		return fechaHoraInicio;
	}

	public void setFechaHoraInicio(Date fechaHoraInicio) {
		this.fechaHoraInicio = fechaHoraInicio;
	}

	public Date getFechaHoraFinalizacion() {
		return fechaHoraFinalizacion;
	}

	public void setFechaHoraFinalizacion(Date fechaHoraFinalizacion) {
		this.fechaHoraFinalizacion = fechaHoraFinalizacion;
	}

	public Float getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(Float velocidad) {
		this.velocidad = velocidad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Drone getDroneAsignado() {
		return droneAsignado;
	}

	public void setDroneAsignado(Drone droneAsignado) {
		this.droneAsignado = droneAsignado;
	}

	public List<PuntoRuta> getPuntosDeRuta() {
		return puntosDeRuta;
	}

	public void setPuntosDeRuta(List<PuntoRuta> puntosDeRuta) {
		this.puntosDeRuta = puntosDeRuta;
	}

}
