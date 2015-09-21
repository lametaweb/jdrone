package com.lametaweb.jdrone.transversal.beanvalidators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.lametaweb.jdrone.persistencia.Trabajo;

public class ComparaFechasValidator implements ConstraintValidator<ComparaFechas, Trabajo> {

  public void initialize(ComparaFechas constraintAnnotation) {
  }

  public boolean isValid(Trabajo trabajo, ConstraintValidatorContext context) {
	
	Boolean assertTrue = trabajo.getFechaHoraInicio()==null || trabajo.getFechaHoraFinalizacion()==null ||
			trabajo.getFechaHoraInicio().before(trabajo.getFechaHoraFinalizacion());

    if (!assertTrue) {
    	context.disableDefaultConstraintViolation();
    	String mensaje = context.getDefaultConstraintMessageTemplate();
        context.buildConstraintViolationWithTemplate(mensaje).addConstraintViolation();        
    }

    return assertTrue;
  }
   
}
