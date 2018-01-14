package br.com.alura.alura_lib.interfaces;

import java.io.Serializable;

import javax.interceptor.InvocationContext;

public interface Transacionado extends Serializable{
	
	Object executaComTransacao(InvocationContext invocationContext);

}
