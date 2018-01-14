package br.com.alura.livraria.tx;

import javax.annotation.Priority;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;

import br.com.alura.alura_lib.interfaces.Transacionado;

@Alternative
@Priority(Interceptor.Priority.APPLICATION)
public class MeuGerenciadorDeTransacao implements Transacionado{

	private static final long serialVersionUID = -8590951365580768798L;
	
	@Inject
	private EntityManager em;
	
	@Override
	public Object executaComTransacao(InvocationContext invocationContext) {
		System.out.println("Antes de abrir a transação");
		em.getTransaction().begin();
		
		try {
			System.out.println("Antes de executar o método interceptado");
			Object object = invocationContext.proceed();
			
			System.out.println("Antes de efetual o commit");
			em.getTransaction().commit();
			
			return object;
		}catch(Exception e) {
			System.out.println("Antes de efetuar o roolback");
			em.getTransaction().rollback();
			throw new RuntimeException(e);
		}
	}
	
	

}
