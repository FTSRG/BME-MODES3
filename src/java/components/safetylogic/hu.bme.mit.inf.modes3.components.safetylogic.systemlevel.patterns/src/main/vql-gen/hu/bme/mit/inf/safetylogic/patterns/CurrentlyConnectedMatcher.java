/**
 * Generated from platform:/resource/hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.patterns/src/main/java/hu/bme/mit/inf/safetylogic/patterns/DerivedFeatures.vql
 */
package hu.bme.mit.inf.safetylogic.patterns;

import hu.bme.mit.inf.safetylogic.patterns.CurrentlyConnectedMatch;
import hu.bme.mit.inf.safetylogic.patterns.util.CurrentlyConnectedQuerySpecification;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.viatra.query.runtime.api.IMatchProcessor;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseMatcher;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuple;
import org.eclipse.viatra.query.runtime.util.ViatraQueryLoggingUtil;

/**
 * Generated pattern matcher API of the hu.bme.mit.inf.safetylogic.patterns.currentlyConnected pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
 * e.g. in conjunction with {@link ViatraQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link CurrentlyConnectedMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * //TODO {@literal @}QueryBasedFeature(feature = "currentlyConnected")
 * pattern currentlyConnected(This : RailRoadElement, connectedTo : RailRoadElement) = {
 * 	Segment(This);
 * 	Segment.connectedTo(This, connectedTo);
 * } or { 
 * 	Turnout(This);
 * 	Turnout.currentlyDivergent(This, true);  
 * 	Turnout.top(This, connectedTo);
 * } or {
 * 	Turnout(This);
 * 	Turnout.currentlyDivergent(This, true);
 * 	Turnout.divergent(This, connectedTo);	
 * } or {
 * 	Turnout(This);
 * 	Turnout.currentlyDivergent(This, false);
 * 	Turnout.top(This, connectedTo);
 * } or {
 * 	Turnout(This);
 * 	Turnout.currentlyDivergent(This, false);
 * 	Turnout.straight(This, connectedTo);
 * }
 * </pre></code>
 * 
 * @see CurrentlyConnectedMatch
 * @see CurrentlyConnectedProcessor
 * @see CurrentlyConnectedQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class CurrentlyConnectedMatcher extends BaseMatcher<CurrentlyConnectedMatch> {
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static CurrentlyConnectedMatcher on(final ViatraQueryEngine engine) throws ViatraQueryException {
    // check if matcher already exists
    CurrentlyConnectedMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new CurrentlyConnectedMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_THIS = 0;
  
  private final static int POSITION_CONNECTEDTO = 1;
  
  private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(CurrentlyConnectedMatcher.class);
  
  /**
   * Initializes the pattern matcher within an existing VIATRA Query engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing VIATRA Query engine in which this matcher will be created.
   * @throws ViatraQueryException if an error occurs during pattern matcher creation
   * 
   */
  private CurrentlyConnectedMatcher(final ViatraQueryEngine engine) throws ViatraQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pThis the fixed value of pattern parameter This, or null if not bound.
   * @param pConnectedTo the fixed value of pattern parameter connectedTo, or null if not bound.
   * @return matches represented as a CurrentlyConnectedMatch object.
   * 
   */
  public Collection<CurrentlyConnectedMatch> getAllMatches(final EObject pThis, final EObject pConnectedTo) {
    return rawGetAllMatches(new Object[]{pThis, pConnectedTo});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pThis the fixed value of pattern parameter This, or null if not bound.
   * @param pConnectedTo the fixed value of pattern parameter connectedTo, or null if not bound.
   * @return a match represented as a CurrentlyConnectedMatch object, or null if no match is found.
   * 
   */
  public CurrentlyConnectedMatch getOneArbitraryMatch(final EObject pThis, final EObject pConnectedTo) {
    return rawGetOneArbitraryMatch(new Object[]{pThis, pConnectedTo});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pThis the fixed value of pattern parameter This, or null if not bound.
   * @param pConnectedTo the fixed value of pattern parameter connectedTo, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final EObject pThis, final EObject pConnectedTo) {
    return rawHasMatch(new Object[]{pThis, pConnectedTo});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pThis the fixed value of pattern parameter This, or null if not bound.
   * @param pConnectedTo the fixed value of pattern parameter connectedTo, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final EObject pThis, final EObject pConnectedTo) {
    return rawCountMatches(new Object[]{pThis, pConnectedTo});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pThis the fixed value of pattern parameter This, or null if not bound.
   * @param pConnectedTo the fixed value of pattern parameter connectedTo, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final EObject pThis, final EObject pConnectedTo, final IMatchProcessor<? super CurrentlyConnectedMatch> processor) {
    rawForEachMatch(new Object[]{pThis, pConnectedTo}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pThis the fixed value of pattern parameter This, or null if not bound.
   * @param pConnectedTo the fixed value of pattern parameter connectedTo, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final EObject pThis, final EObject pConnectedTo, final IMatchProcessor<? super CurrentlyConnectedMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pThis, pConnectedTo}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pThis the fixed value of pattern parameter This, or null if not bound.
   * @param pConnectedTo the fixed value of pattern parameter connectedTo, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public CurrentlyConnectedMatch newMatch(final EObject pThis, final EObject pConnectedTo) {
    return CurrentlyConnectedMatch.newMatch(pThis, pConnectedTo);
  }
  
  /**
   * Retrieve the set of values that occur in matches for This.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<EObject> rawAccumulateAllValuesOfThis(final Object[] parameters) {
    Set<EObject> results = new HashSet<EObject>();
    rawAccumulateAllValues(POSITION_THIS, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for This.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<EObject> getAllValuesOfThis() {
    return rawAccumulateAllValuesOfThis(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for This.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<EObject> getAllValuesOfThis(final CurrentlyConnectedMatch partialMatch) {
    return rawAccumulateAllValuesOfThis(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for This.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<EObject> getAllValuesOfThis(final EObject pConnectedTo) {
    return rawAccumulateAllValuesOfThis(new Object[]{
    null, 
    pConnectedTo
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for connectedTo.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<EObject> rawAccumulateAllValuesOfconnectedTo(final Object[] parameters) {
    Set<EObject> results = new HashSet<EObject>();
    rawAccumulateAllValues(POSITION_CONNECTEDTO, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for connectedTo.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<EObject> getAllValuesOfconnectedTo() {
    return rawAccumulateAllValuesOfconnectedTo(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for connectedTo.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<EObject> getAllValuesOfconnectedTo(final CurrentlyConnectedMatch partialMatch) {
    return rawAccumulateAllValuesOfconnectedTo(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for connectedTo.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<EObject> getAllValuesOfconnectedTo(final EObject pThis) {
    return rawAccumulateAllValuesOfconnectedTo(new Object[]{
    pThis, 
    null
    });
  }
  
  @Override
  protected CurrentlyConnectedMatch tupleToMatch(final Tuple t) {
    try {
    	return CurrentlyConnectedMatch.newMatch((EObject) t.get(POSITION_THIS), (EObject) t.get(POSITION_CONNECTEDTO));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected CurrentlyConnectedMatch arrayToMatch(final Object[] match) {
    try {
    	return CurrentlyConnectedMatch.newMatch((EObject) match[POSITION_THIS], (EObject) match[POSITION_CONNECTEDTO]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected CurrentlyConnectedMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return CurrentlyConnectedMatch.newMutableMatch((EObject) match[POSITION_THIS], (EObject) match[POSITION_CONNECTEDTO]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  /**
   * @return the singleton instance of the query specification of this pattern
   * @throws ViatraQueryException if the pattern definition could not be loaded
   * 
   */
  public static IQuerySpecification<CurrentlyConnectedMatcher> querySpecification() throws ViatraQueryException {
    return CurrentlyConnectedQuerySpecification.instance();
  }
}
