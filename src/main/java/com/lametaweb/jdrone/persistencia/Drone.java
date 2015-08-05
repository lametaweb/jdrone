package com.lametaweb.jdrone.persistencia;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.Range;

@Entity
@NamedQueries({
    @NamedQuery(name="Drone.estadoDronesPorFecha",
                query="select d " +
    			"from Drone d inner join d.trabajosAsignados t " +
    			"where t.fechaHoraInicio < :fecha " +
    			"and t.fechaHoraFinalizacion > :fecha " + 
    			"order by d.numeroDeSerie"
				)
}) 
public class Drone implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)	
	private Integer idDrone;
	
	@Basic(optional = false)
	@Column(unique = true)
	private String numeroDeSerie;
	
	private String modelo;
	private Integer autonomia;
	
	@Range(min = 4, max = 8)
	private Integer numMotores;
	private Integer pesoMaximoDespegue;
	
	// @OneToMany es LAZY por defecto
	@OneToMany(mappedBy = "droneAsignado")
	private List<Trabajo> trabajosAsignados = new ArrayList<Trabajo>();
	
	@Override
	public String toString() {
		return "Drone [numeroDeSerie=" + numeroDeSerie + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((numeroDeSerie == null) ? 0 : numeroDeSerie.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Drone))
			return false;
		Drone other = (Drone) obj;
		if (numeroDeSerie == null) {
			if (other.numeroDeSerie != null)
				return false;
		} else if (!numeroDeSerie.equals(other.numeroDeSerie))
			return false;
		return true;
	}

	public Integer getIdDrone() {
		return idDrone;
	}
	public void setIdDrone(Integer idDrone) {
		this.idDrone = idDrone;
	}
	public String getNumeroDeSerie() {
		return numeroDeSerie;
	}
	public void setNumeroDeSerie(String numeroDeSerie) {
		this.numeroDeSerie = numeroDeSerie;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public Integer getAutonomia() {
		return autonomia;
	}
	public void setAutonomia(Integer autonomia) {
		this.autonomia = autonomia;
	}
	public Integer getNumMotores() {
		return numMotores;
	}
	public void setNumMotores(Integer numMotores) {
		this.numMotores = numMotores;
	}
	public Integer getPesoMaximoDespegue() {
		return pesoMaximoDespegue;
	}
	public void setPesoMaximoDespegue(Integer pesoMaximoDespegue) {
		this.pesoMaximoDespegue = pesoMaximoDespegue;
	}
	public List<Trabajo> getTrabajosAsignados() {
		return trabajosAsignados;
	}
	public void setTrabajosAsignados(List<Trabajo> trabajosAsignados) {
		this.trabajosAsignados = trabajosAsignados;
	}	
}
