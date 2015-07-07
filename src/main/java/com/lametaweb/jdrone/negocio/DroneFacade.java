package com.lametaweb.jdrone.negocio;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.lametaweb.jdrone.persistencia.Drone;

/**
 * Session Bean implementation class DroneFacade
 */
@Stateless
@LocalBean
public class DroneFacade { 
	
	@PersistenceContext(unitName = "datosdrones")
    private EntityManager em;

    /**
     * Default constructor. 
     */
    public DroneFacade() {
        // TODO Auto-generated constructor stub
    }
    
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Drone> obtenEstadoDronesPorFecha(Date fecha){
    	String consulta = "select d " +
    			"from Drone d inner join d.trabajosAsignados t " +
    			"where t.fechaHoraInicio < :fecha " +
    			"and t.fechaHoraFinalizacion > :fecha " + 
    			"order by d.numeroDeSerie";

    	return em.createQuery(consulta, Drone.class).
    	setParameter("fecha", fecha).
    	getResultList();
    	
    }
    
    public List<Drone> obtenEstadoDronesPorFechaNamed(Date fecha){

    	return em.createNamedQuery("Drone.estadoDronesPorFecha", Drone.class).
    	setParameter("fecha", fecha).
    	getResultList();
    	
    }    
}
