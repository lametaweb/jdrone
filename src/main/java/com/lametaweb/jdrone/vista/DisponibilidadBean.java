package com.lametaweb.jdrone.vista;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.lametaweb.jdrone.negocio.DroneFacade;
import com.lametaweb.jdrone.persistencia.Drone;

@Named
@RequestScoped
public class DisponibilidadBean {

	private Date fecha;
	private Date hora;
	
	@Inject
	private DroneFacade droneFacade;
	
	private List<Drone> drones;	
	
	public DisponibilidadBean() {
		// TODO Auto-generated constructor stub
	}
	
	public void listaEstadoDronesPorFecha(){
		
		if(!FacesContext.getCurrentInstance().isPostback()) return;
		
		TimeZone timeZone = new SimpleTimeZone(0,"GMT+02");
		Calendar calendar = new GregorianCalendar(timeZone);
		calendar.setTime(hora);
		int horas = calendar.get(Calendar.HOUR_OF_DAY);
		int minutos = calendar.get(Calendar.MINUTE);
		
		calendar.setTime(this.fecha);
		calendar.add(Calendar.HOUR, horas-2);
		calendar.add(Calendar.MINUTE, minutos);
	
		Date fechaAjustada = calendar.getTime();
		
		this.drones =  droneFacade.obtenEstadoDronesPorFechaNamed(fechaAjustada);
	}	

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

	public List<Drone> getDrones() {
		return drones;
	}
}
