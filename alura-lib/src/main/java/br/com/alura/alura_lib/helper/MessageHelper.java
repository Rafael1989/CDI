package br.com.alura.alura_lib.helper;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.inject.Inject;

public class MessageHelper {

	private FacesContext facesContext;
	private Flash flash;

	@Inject
	public MessageHelper(FacesContext facesContext, Flash flash) {
		this.facesContext = facesContext;
		this.flash = flash;
	}
	
	public MessageHelper onFlash() {
		flash.setKeepMessages(true);
		return this;
	}
	
	public void addMessage(FacesMessage facesMessage) {
		addMessage(null,facesMessage);
	}
	
	public void addMessage(String clientId, FacesMessage facesMessage) {
		this.facesContext.addMessage(clientId, facesMessage);
	}
}
