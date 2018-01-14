package br.com.alura.livraria.bean;

import java.io.Serializable;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.alura.alura_lib.annotation.ScopeMap;
import br.com.alura.alura_lib.annotation.ScopeMap.Scope;
import br.com.alura.alura_lib.helper.MessageHelper;
import br.com.alura.livraria.dao.UsuarioDao;
import br.com.alura.livraria.modelo.Usuario;

@Named
@RequestScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Usuario usuario = new Usuario();

	private UsuarioDao usuarioDao;

	private Map<String, Object> sessionMap;

	private MessageHelper messageHelper;
	
	@Inject
	public LoginBean(UsuarioDao usuarioDao, @ScopeMap(Scope.SESSION) Map<String, Object> sessionMap, MessageHelper messageHelper) {
		this.usuarioDao = usuarioDao;
		this.sessionMap = sessionMap;
		this.messageHelper = messageHelper;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	
	public String efetuaLogin() {
		System.out.println("fazendo login do usuario " + this.usuario.getEmail());
		
		boolean existe = this.usuarioDao.existe(this.usuario);
		if(existe ) {
			sessionMap.put("usuarioLogado", this.usuario);
			return "livro?faces-redirect=true";
		}
		
		messageHelper.onFlash();
		messageHelper.addMessage(null, new FacesMessage("Usuário não encontrado"));
		
		return "login?faces-redirect=true";
	}
	
	public String deslogar() {
		sessionMap.remove("usuarioLogado");
		return "login?faces-redirect=true";
	}
}
