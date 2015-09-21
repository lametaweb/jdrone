package com.lametaweb.jdrone.negocio;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.lametaweb.jdrone.persistencia.Trabajo;

/**
 * Session Bean implementation class TrabajoFacade
 */
@Stateless
@LocalBean
public class TrabajoFacade extends AbstractFacade<Trabajo>{
	
	@PersistenceContext(unitName = "datosdrones")
    private EntityManager em;

    /**
     * Default constructor. 
     */
    public TrabajoFacade() {
        // TODO Auto-generated constructor stub
    	super(Trabajo.class);
    }
    
    protected EntityManager getEntityManager(){
    	return em;
    }
    
    // comprobación de restricción de clave natural (unique)
    public List findByNaturalId(String numeroDeRegistro){
        return em.createNamedQuery("Trabajo.findByNaturalId").
                setParameter("numeroDeRegistro", numeroDeRegistro).getResultList();    	
    }
    

}
