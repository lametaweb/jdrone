package com.lametaweb.jdrone.control;

import java.util.Date;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.lametaweb.jdrone.negocio.DroneFacade;
import com.lametaweb.jdrone.persistencia.Drone;

@Named
@RequestScoped
public class DisponibilidadControlador { 
	
	private Date fecha;
	private int horas;
	private int minutos;
	
	@Inject
	private DroneFacade droneFacade;
	
	private List<Drone> drones;

	public DisponibilidadControlador() {
		// TODO Auto-generated constructor stub
	}
	
	public void listaEstadoDronesPorFecha(){

		Date fechaAjustada = this.fecha!=null?new Date(this.fecha.getTime() + 
				this.horas * 60 * 60 * 1000 +
				this.minutos * 60 * 1000):null;
		
		this.drones =  droneFacade.obtenEstadoDronesPorFechaNamed(fechaAjustada);
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public List<Drone> getDrones() {
		return drones;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public int getMinutos() {
		return minutos;
	}

	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}	
	
}
