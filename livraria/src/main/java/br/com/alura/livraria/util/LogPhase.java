package br.com.alura.livraria.util;

import javax.enterprise.event.Observes;
import javax.faces.event.PhaseEvent;

import br.com.alura.alura_lib.annotation.Before;
import br.com.alura.alura_lib.annotation.Phase;
import br.com.alura.alura_lib.annotation.Phase.Phases;

public class LogPhase {
	
	public void log(@Observes @Before @Phase(Phases.RESTORE_VIEW)PhaseEvent phaseEvent) {
		System.out.println("Fase: " + phaseEvent.getPhaseId());
	}

}
