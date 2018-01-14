package br.com.alura.alura_lib.listener;

import java.lang.annotation.Annotation;

import javax.enterprise.inject.Vetoed;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.CDI;
import javax.enterprise.util.AnnotationLiteral;
import javax.faces.event.PhaseEvent;

import br.com.alura.alura_lib.annotation.After;
import br.com.alura.alura_lib.annotation.Before;
@Vetoed
public class PhaseListenerObserver {
	
	private BeanManager observer = CDI.current().getBeanManager();
	private Annotation momento;
	
	public PhaseListenerObserver after() {
		this.momento = new AnnotationLiteral<After>() {};
		return this;
	}
	
	public PhaseListenerObserver before() {
		this.momento = new AnnotationLiteral<Before>() {};
		return this;
	}
	
	public void fire(PhaseEvent phaseEvent) {
		observer.fireEvent(phaseEvent, momento,new PhaseLiteral(phaseEvent.getPhaseId()));
	}

}
