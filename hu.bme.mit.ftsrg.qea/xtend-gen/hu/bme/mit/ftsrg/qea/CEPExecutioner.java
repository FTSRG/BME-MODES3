package hu.bme.mit.ftsrg.qea;

import hu.bme.mit.ftsrg.qea.AutomatonExecutioner;
import hu.bme.mit.ftsrg.qea.model.Automaton;
import hu.bme.mit.ftsrg.qea.model.ComplexEventProcessor;
import hu.bme.mit.ftsrg.qea.model.Event;
import hu.bme.mit.ftsrg.qea.model.SymbolicEvent;
import java.util.HashMap;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.InputOutput;

@SuppressWarnings("all")
public class CEPExecutioner {
  protected final ComplexEventProcessor cep;
  
  protected final HashMap<Automaton, AutomatonExecutioner> executioners = new HashMap<Automaton, AutomatonExecutioner>();
  
  public CEPExecutioner(final ComplexEventProcessor cep) {
    this.cep = cep;
    EList<Automaton> _automata = cep.getAutomata();
    final Consumer<Automaton> _function = (Automaton it) -> {
      AutomatonExecutioner _automatonExecutioner = new AutomatonExecutioner(it);
      this.executioners.put(it, _automatonExecutioner);
    };
    _automata.forEach(_function);
  }
  
  public void pushEvent(final Event e) {
    InputOutput.<String>println("================ STEP FINISHED ==================");
    SymbolicEvent _type = e.getType();
    String _name = _type.getName();
    String _plus = ("Caused by event " + _name);
    InputOutput.<String>println(_plus);
    InputOutput.<String>println("=================================================");
    final BiConsumer<Automaton, AutomatonExecutioner> _function = (Automaton automata, AutomatonExecutioner executioner) -> {
      executioner.pushEvent(e);
    };
    this.executioners.forEach(_function);
  }
}
