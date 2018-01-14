package br.com.alura.alura_lib.factory;

import java.lang.reflect.ParameterizedType;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.alura.alura_lib.annotation.Query;

public class TypedQueryFactory {
	
	@Inject
	private EntityManager entityManager;
	
	@Produces
	@Query("")
	public <X> TypedQuery<X> factory(InjectionPoint injectionPoint){
		ParameterizedType parameterizedType = (ParameterizedType)injectionPoint.getType();
		@SuppressWarnings("unchecked")
		Class<X> classe = (Class<X>)parameterizedType.getActualTypeArguments()[0];
		String jpql = injectionPoint.getAnnotated().getAnnotation(Query.class).value();
		return entityManager.createQuery(jpql,classe);
	}
	

}
