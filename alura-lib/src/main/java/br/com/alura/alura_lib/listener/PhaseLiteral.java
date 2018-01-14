package br.com.alura.alura_lib.listener;

import javax.enterprise.util.AnnotationLiteral;
import javax.faces.event.PhaseId;

import br.com.alura.alura_lib.annotation.Phase;

public class PhaseLiteral extends AnnotationLiteral<Phase> implements Phase{

	private static final long serialVersionUID = -4594978679270178135L;
	private Phases phases;
	
	public PhaseLiteral(PhaseId phaseId) {
		phases = Phase.Phases.valueOf(phaseId.getName());
	}

	@Override
	public Phases value() {
		return phases;
	}

}
