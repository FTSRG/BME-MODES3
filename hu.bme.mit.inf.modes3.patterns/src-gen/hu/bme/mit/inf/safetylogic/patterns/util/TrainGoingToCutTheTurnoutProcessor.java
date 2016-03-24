package hu.bme.mit.inf.safetylogic.patterns.util;

import org.eclipse.incquery.runtime.api.IMatchProcessor;

import hu.bme.mit.inf.safetylogic.model.railroadmodel.Train;
import hu.bme.mit.inf.safetylogic.model.railroadmodel.Turnout;
import hu.bme.mit.inf.safetylogic.patterns.TrainGoingToCutTheTurnoutMatch;

/**
 * A match processor tailored for the hu.bme.mit.inf.safetylogic.patterns.trainGoingToCutTheTurnout pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class TrainGoingToCutTheTurnoutProcessor implements IMatchProcessor<TrainGoingToCutTheTurnoutMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pTrain the value of pattern parameter train in the currently processed match
   * @param pTurnout the value of pattern parameter turnout in the currently processed match
   * 
   */
  public abstract void process(final Train pTrain, final Turnout pTurnout);
  
  @Override
  public void process(final TrainGoingToCutTheTurnoutMatch match) {
    process(match.getTrain(), match.getTurnout());
  }
}