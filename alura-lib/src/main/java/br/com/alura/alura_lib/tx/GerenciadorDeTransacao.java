package br.com.alura.alura_lib.tx;

import java.io.Serializable;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import br.com.alura.alura_lib.annotation.Transacional;
import br.com.alura.alura_lib.interfaces.Transacionado;

@Interceptor
@Transacional
public class GerenciadorDeTransacao implements Serializable{

	private static final long serialVersionUID = -8596416919645954801L;
	
	private Transacionado transacionado;
	
	@Inject
	public GerenciadorDeTransacao(Transacionado transacionado) {
		this.transacionado = transacionado;
	}
	
	@AroundInvoke
	public Object efetuaComTransacao(InvocationContext invocationContext) {
		return transacionado.executaComTransacao(invocationContext);
	}

}
