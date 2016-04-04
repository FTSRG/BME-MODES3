package hu.bme.mit.inf.safetylogic.patterns;

import hu.bme.mit.inf.safetylogic.model.railroadmodel.Section;
import hu.bme.mit.inf.safetylogic.patterns.util.SoloCounterClockwiseBlindTrackQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the hu.bme.mit.inf.safetylogic.patterns.soloCounterClockwiseBlindTrack pattern,
 * to be used in conjunction with {@link SoloCounterClockwiseBlindTrackMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see SoloCounterClockwiseBlindTrackMatcher
 * @see SoloCounterClockwiseBlindTrackProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class SoloCounterClockwiseBlindTrackMatch extends BasePatternMatch {
  private Section fSection;
  
  private static List<String> parameterNames = makeImmutableList("section");
  
  private SoloCounterClockwiseBlindTrackMatch(final Section pSection) {
    this.fSection = pSection;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("section".equals(parameterName)) return this.fSection;
    return null;
  }
  
  public Section getSection() {
    return this.fSection;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("section".equals(parameterName) ) {
    	this.fSection = (Section) newValue;
    	return true;
    }
    return false;
  }
  
  public void setSection(final Section pSection) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fSection = pSection;
  }
  
  @Override
  public String patternName() {
    return "hu.bme.mit.inf.safetylogic.patterns.soloCounterClockwiseBlindTrack";
  }
  
  @Override
  public List<String> parameterNames() {
    return SoloCounterClockwiseBlindTrackMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fSection};
  }
  
  @Override
  public SoloCounterClockwiseBlindTrackMatch toImmutable() {
    return isMutable() ? newMatch(fSection) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"section\"=" + prettyPrintValue(fSection)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fSection == null) ? 0 : fSection.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof SoloCounterClockwiseBlindTrackMatch)) { // this should be infrequent
    	if (obj == null) {
    		return false;
    	}
    	if (!(obj instanceof IPatternMatch)) {
    		return false;
    	}
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    SoloCounterClockwiseBlindTrackMatch other = (SoloCounterClockwiseBlindTrackMatch) obj;
    if (fSection == null) {if (other.fSection != null) return false;}
    else if (!fSection.equals(other.fSection)) return false;
    return true;
  }
  
  @Override
  public SoloCounterClockwiseBlindTrackQuerySpecification specification() {
    try {
    	return SoloCounterClockwiseBlindTrackQuerySpecification.instance();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the query specification exists
     	throw new IllegalStateException (ex);
    }
  }
  
  /**
   * Returns an empty, mutable match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @return the empty match.
   * 
   */
  public static SoloCounterClockwiseBlindTrackMatch newEmptyMatch() {
    return new Mutable(null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pSection the fixed value of pattern parameter section, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static SoloCounterClockwiseBlindTrackMatch newMutableMatch(final Section pSection) {
    return new Mutable(pSection);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSection the fixed value of pattern parameter section, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static SoloCounterClockwiseBlindTrackMatch newMatch(final Section pSection) {
    return new Immutable(pSection);
  }
  
  private static final class Mutable extends SoloCounterClockwiseBlindTrackMatch {
    Mutable(final Section pSection) {
      super(pSection);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends SoloCounterClockwiseBlindTrackMatch {
    Immutable(final Section pSection) {
      super(pSection);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
