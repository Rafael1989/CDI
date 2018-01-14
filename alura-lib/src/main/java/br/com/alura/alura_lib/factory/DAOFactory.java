package br.com.alura.alura_lib.factory;

import java.lang.reflect.ParameterizedType;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.alura.alura_lib.dao.DAO;

@SuppressWarnings("unchecked")
public class DAOFactory {

	@Inject
	private EntityManager entityManager;
	
	@Produces
	public <T,I> DAO<T,I> factory(InjectionPoint injectionPoint) {
		ParameterizedType parameterizedType = (ParameterizedType) injectionPoint.getType();
		Class<T> classe = (Class<T>) parameterizedType.getActualTypeArguments()[0];
		return new DAO<T,I>(classe,this.entityManager);
	}
}
