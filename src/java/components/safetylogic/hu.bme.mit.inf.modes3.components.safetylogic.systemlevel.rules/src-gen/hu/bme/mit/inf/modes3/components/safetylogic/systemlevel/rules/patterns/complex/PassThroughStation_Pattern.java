package hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.patterns.complex;

import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.patterns.complex.anonymous._AnonymousPattern_1;
import org.eclipse.viatra.cep.core.api.patterns.ParameterizableComplexEventPattern;
import org.eclipse.viatra.cep.core.metamodels.automaton.EventContext;
import org.eclipse.viatra.cep.core.metamodels.events.EventsFactory;
import org.eclipse.viatra.cep.core.metamodels.events.Timewindow;

@SuppressWarnings("all")
public class PassThroughStation_Pattern extends ParameterizableComplexEventPattern {
  public PassThroughStation_Pattern() {
    super();
    setOperator(EventsFactory.eINSTANCE.createFOLLOWS());
    
    // contained event patterns
    addEventPatternRefrence(new _AnonymousPattern_1(), 1);
    						
    Timewindow timewindow = EventsFactory.eINSTANCE.createTimewindow();
    timewindow.setTime(10000);
    setTimewindow(timewindow);
    	
    setId("hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.rules.patterns.complex.passthroughstation_pattern");setEventContext(EventContext.CHRONICLE);
  }
}
