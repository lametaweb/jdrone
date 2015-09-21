package com.lametaweb.jdrone.vista.validators;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;

@Named
public class FechaAnteriorValidator implements Validator{
	
	public FechaAnteriorValidator(){}
	
	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {	

		Date fechaAnterior = (Date)value;
		Date fechaPosterior;
		UIInput componentFechaPosterior = (UIInput) component.getAttributes().get("fechaPosterior");
		String patron = (String)component.getAttributes().get("pattern");
		SimpleDateFormat formatoDeFecha = new SimpleDateFormat(patron);
		String sfechaPosterior = (String)componentFechaPosterior.getSubmittedValue();
		try{ fechaPosterior = formatoDeFecha.parse(sfechaPosterior);
		}catch(ParseException e){fechaPosterior = null;}
		Boolean isValid = fechaPosterior == null || fechaAnterior == null || fechaAnterior.before(fechaPosterior);
		
		if(!isValid){
			FacesMessage message = new FacesMessage("La fecha de inicio debe ser anterior a la fecha de finalización.");
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(message);
		}
		
	}
}
