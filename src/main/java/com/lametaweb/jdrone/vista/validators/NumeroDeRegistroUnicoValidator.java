package com.lametaweb.jdrone.vista.validators;

import javax.el.ValueExpression;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;

import com.lametaweb.jdrone.negocio.TrabajoFacade;
import com.lametaweb.jdrone.vista.TrabajoBean;

@Named
public class NumeroDeRegistroUnicoValidator implements Validator{

	@Inject
	TrabajoFacade trabajoFacade;
	
	public NumeroDeRegistroUnicoValidator(){}
	
	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {	
		// Comprueba si existe un Trabajo con el mismo Numero de Registro en la base de datos
		ValueExpression expression = context.getApplication().getExpressionFactory().
				createValueExpression( context.getELContext(), "#{trabajoBean}", Object.class);
		TrabajoBean trabajoBean = (TrabajoBean) expression.getValue(context.getELContext());
		String numeroDeRegistroActual = trabajoBean.getTrabajo().getNumeroDeRegistro();
		String numeroDeRegistroNuevo = value.toString();
		Boolean isPosibleEdicionClaveNatural = (Boolean)component.getAttributes().get("isPosibleEdicionClaveNatural");
		Boolean isAlta = numeroDeRegistroActual == null;
		Boolean isNumeroDeRegistroExiste = trabajoFacade.findByNaturalId(numeroDeRegistroNuevo).size() > 0;
		
		Boolean isRestriccionCampoUnicoViolada =
				(isAlta && isNumeroDeRegistroExiste) ||
				(!isAlta && !isPosibleEdicionClaveNatural) ||
				(!isAlta && isPosibleEdicionClaveNatural && isNumeroDeRegistroExiste && 
						!numeroDeRegistroActual.equals(numeroDeRegistroNuevo));
		
		if(isRestriccionCampoUnicoViolada){
			FacesMessage message = new FacesMessage("Ya existe un Trabajo con el mismo Número de Registro en la Base de datos.");
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(message);
		}
	}
}
