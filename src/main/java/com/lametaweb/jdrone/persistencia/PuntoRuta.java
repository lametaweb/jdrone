package com.lametaweb.jdrone.persistencia;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PuntoRuta implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)	
	private Integer idPuntoRuta;
	
	@Basic(optional = false)
	private Float latitud;
	@Basic(optional = false)
	private Float longitud;
	@Basic(optional = false)
	private Float altitud;
	
	public Integer getIdPuntoRuta() {
		return idPuntoRuta;
	}
	public void setIdPuntoRuta(Integer idPuntoRuta) {
		this.idPuntoRuta = idPuntoRuta;
	}
	public Float getLatitud() {
		return latitud;
	}
	public void setLatitud(Float latitud) {
		this.latitud = latitud;
	}
	public Float getLongitud() {
		return longitud;
	}
	public void setLongitud(Float longitud) {
		this.longitud = longitud;
	}
	public Float getAltitud() {
		return altitud;
	}
	public void setAltitud(Float altitud) {
		this.altitud = altitud;
	}

}
