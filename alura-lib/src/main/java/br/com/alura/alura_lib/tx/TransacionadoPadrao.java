package br.com.alura.alura_lib.tx;

import javax.inject.Inject;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;

import br.com.alura.alura_lib.interfaces.Transacionado;

public class TransacionadoPadrao implements Transacionado{
	
	private static final long serialVersionUID = -3167414201127663729L;
	
	@Inject
	private EntityManager em;

	@Override
	public Object executaComTransacao(InvocationContext invocationContext) {
		em.getTransaction().begin();
		try {
			Object object = invocationContext.proceed();
			em.getTransaction().commit();
			return object;
		}catch(Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}

}
