package com.lametaweb.jdrone.vista;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.CellEditEvent;

import com.lametaweb.jdrone.negocio.DroneFacade;
import com.lametaweb.jdrone.negocio.TrabajoFacade;
import com.lametaweb.jdrone.persistencia.Drone;
import com.lametaweb.jdrone.persistencia.Trabajo;

@Named
@ViewScoped
public class TrabajoBean  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Trabajo trabajo;
	private List<Drone> drones;
	
	@Inject
	private TrabajoFacade trabajoFacade;
	@Inject
	private DroneFacade droneFacade;	

	public TrabajoBean() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void creaTrabajo(){
		trabajo = new Trabajo();
	}
	
	public void actualizaModeloTrabajo(){
		// actualiza trabajo
		if(trabajo.getIdTrabajo()!=null)
			trabajo = trabajoFacade.find(trabajo.getIdTrabajo());
		// carga drones para selectOneMenu
		drones = droneFacade.findAll();
	}
	
	public String aceptar(){
		trabajoFacade.edit(trabajo);
		return "/trabajos?faces-redirect=true";
	}

	public Trabajo getTrabajo() {
		return trabajo;
	}

	public void setTrabajo(Trabajo trabajo) {
		this.trabajo = trabajo;
	}

	public List<Drone> getDrones() {
		return drones;
	}

	public void setDrones(List<Drone> drones) {
		this.drones = drones;
	}
	
	

}
