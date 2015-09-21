package com.lametaweb.jdrone.vista;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpServletResponse;
 
public class CacheControlPhaseListener implements PhaseListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    public PhaseId getPhaseId()
    {
        return PhaseId.RENDER_RESPONSE;
    }
	
	@Override
    public void afterPhase(PhaseEvent event)
    {
    }
 
	@Override
    public void beforePhase(PhaseEvent event)
    {
        FacesContext facesContext = event.getFacesContext();
        // or use this condition: "p3.xhtml".equals(facesContext.getViewRoot().getViewId())
        if("/trabajo.xhtml".equals(facesContext.getExternalContext().getRequestServletPath())){
	        HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
	        response.addHeader("Pragma", "no-cache");
	        response.addHeader("Cache-Control", "no-cache");
	        // Stronger according to blog comment below that references HTTP spec
	        response.addHeader("Cache-Control", "no-store");
	        response.addHeader("Cache-Control", "must-revalidate");
	        // some date in the past
	        response.addHeader("Expires", "Mon, 8 Aug 2006 10:00:00 GMT");
        }
    }
}
