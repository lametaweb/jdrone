package com.lametaweb.jdrone.negocio;

import java.util.Date;
import java.util.GregorianCalendar;
import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.lametaweb.jdrone.persistencia.Drone;
import com.lametaweb.jdrone.persistencia.PuntoRuta;
import com.lametaweb.jdrone.persistencia.Trabajo;

/**
 * Session Bean implementation class CargaInicialDatos
 */
@Singleton
@Startup
@LocalBean
public class CargaInicialDatos {

    /**
     * Default constructor. 
     */
	
    @PersistenceContext(unitName = "datosdrones")
    private EntityManager em;
    
    public CargaInicialDatos() {
        // TODO Auto-generated constructor stub
    }
    
    @PostConstruct
    public void cargaDeDatos(){
    	
    	// Puntos de Ruta
		PuntoRuta puntoRuta01 = new PuntoRuta();
		PuntoRuta puntoRuta02 = new PuntoRuta();
		PuntoRuta puntoRuta03 = new PuntoRuta();
		PuntoRuta puntoRuta04 = new PuntoRuta();
		PuntoRuta puntoRuta05 = new PuntoRuta();

		// Datos Puntos de Ruta
		puntoRuta01.setLatitud(37.367873f);
		puntoRuta01.setLongitud(-6.003724f);
		puntoRuta01.setAltitud(100.0f);
		puntoRuta02.setLatitud(37.374797f);
		puntoRuta02.setLongitud(-5.996119f);
		puntoRuta02.setAltitud(200.0f);
		puntoRuta03.setLatitud(37.372000f);
		puntoRuta03.setLongitud(-5.992500f);
		puntoRuta03.setAltitud(300.0f);
		puntoRuta04.setLatitud(37.367873f);
		puntoRuta04.setLongitud(-6.003724f);
		puntoRuta04.setAltitud(100.0f);
		puntoRuta05.setLatitud(37.367873f);
		puntoRuta05.setLongitud(-6.003724f);
		puntoRuta05.setAltitud(0.0f);

		GregorianCalendar gc = new GregorianCalendar();
		// hora inicio adelantando una hora
		gc.add(GregorianCalendar.HOUR, -1);
		Date fechaHoraInicio = gc.getTime();
		// hora finalización atrasando una hora
		gc.add(GregorianCalendar.HOUR, 2);
		Date fechaHoraFinalizacion = gc.getTime();
		
		Trabajo trabajo = new Trabajo();
		trabajo.setNumeroDeRegistro("trabajo");
		trabajo.setVelocidad(10f);
		trabajo.setDescripcion("Reconocimiento de zona a baja cota.");
		trabajo.setFechaHoraInicio(fechaHoraInicio);
		trabajo.setFechaHoraFinalizacion(fechaHoraFinalizacion);
		
		trabajo.getPuntosDeRuta().add(puntoRuta01);
		trabajo.getPuntosDeRuta().add(puntoRuta02);
		trabajo.getPuntosDeRuta().add(puntoRuta03);
		trabajo.getPuntosDeRuta().add(puntoRuta04);
		trabajo.getPuntosDeRuta().add(puntoRuta05);
		
		Drone drone = new Drone();
		drone.setNumeroDeSerie("FJHCAM01001");
		drone.setModelo("Observer II");
		drone.setPesoMaximoDespegue(1500);
		drone.setAutonomia(25);
		drone.setNumMotores(6);
		em.persist(drone);
		em.persist(trabajo);
		
		trabajo.setDroneAsignado(drone);
    	
    } 
}
