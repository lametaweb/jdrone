package com.lametaweb.jdrone.vista;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.lametaweb.jdrone.negocio.TrabajoFacade;
import com.lametaweb.jdrone.persistencia.Trabajo;

@Named
@ViewScoped
public class TrabajosBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private List<Trabajo> trabajos;
	@Inject
	private TrabajoFacade trabajoFacade;

	public TrabajosBean() {
		// TODO Auto-generated constructor stub
	}
	
	public String eliminar(Trabajo trabajo){
		trabajoFacade.remove(trabajo);
		actualizaModeloTrabajos();
		return "";
	}
    
	public void actualizaModeloTrabajos(){
		trabajos = trabajoFacade.findAll();
	}
	
	
	public List<Trabajo> getTrabajos() {
		return trabajos;
	}
}
