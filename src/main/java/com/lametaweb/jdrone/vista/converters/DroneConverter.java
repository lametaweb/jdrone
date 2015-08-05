								package com.lametaweb.jdrone.vista.converters;

import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.lametaweb.jdrone.persistencia.Drone;

@FacesConverter("droneConverter")
public class DroneConverter  implements Converter{

    public DroneConverter(){}
    
    @Override
      public Object getAsObject(FacesContext facesContext, UIComponent component, String submittedValue) {
          List<Drone> drones = (List<Drone>)component.getAttributes().get("attrdrones");
        if (submittedValue.trim().equals("")) {
            return null;
        } else {
            Iterator<Drone> it = drones.iterator();
            while(it.hasNext()){
            	Drone p = it.next();
                if(p.toString().equals(submittedValue))
                    return p;                
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object value) {
        if (value == null) {
            return "";
        } else {
            return value.toString();
        }
    }
}
