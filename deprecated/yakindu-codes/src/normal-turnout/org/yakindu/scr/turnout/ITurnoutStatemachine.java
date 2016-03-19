package org.yakindu.scr.turnout;

import java.util.List;
import org.yakindu.scr.IStatemachine;

public interface ITurnoutStatemachine extends IStatemachine {

    public interface SCISections {

        public boolean isRaisedRemPassageDeniedToAll();

        public long getSTRAIGHT();

        public long getDIVERGENT();

        public long getTOP();

        public List<SCISectionsListener> getListeners();

    }

    public interface SCISectionsListener {

        public void onRemPassageDeniedToAllRaised();
    }

    public SCISections getSCISections();

    public interface SCITurnout {

        public void raiseTurnoutStraight();

        public void raiseTurnoutDivergent();

        public void raisePassingAllowedFrom(long value);

        public void raisePassingDeniedFrom(long value);

        public void raiseRemPassageAllowedFrom(long value);

        public void raiseRemPassageDeniedFrom(long value);

        public void raiseSectionLockFrom(long value);

        public void raiseRemSectionLockFrom(long value);

        public boolean isRaisedSectionAllowedTo();

        public long getSectionAllowedToValue();

        public boolean isRaisedSectionLockedTo();

        public long getSectionLockedToValue();

        public boolean isRaisedSectionLockedWithReplyTo();

        public long getSectionLockedWithReplyToValue();

        public boolean isRaisedLockRequestTo();

        public long getLockRequestToValue();

        public boolean isRaisedRemShortPassageRequestTo();

        public long getRemShortPassageRequestToValue();

        public boolean isRaisedRemPassageAllowedTo();

        public long getRemPassageAllowedToValue();

        public boolean isRaisedRemPassageDeniedTo();

        public long getRemPassageDeniedToValue();

        public boolean isRaisedRemPassageRequestTo();

        public long getRemPassageRequestToValue();

        public long getId();

        public void setId(long value);

        public boolean getIsOccupied();

        public void setIsOccupied(boolean value);

        public boolean getTopExists();

        public void setTopExists(boolean value);

        public boolean getDivergentExists();

        public void setDivergentExists(boolean value);

        public boolean getStraightExists();

        public void setStraightExists(boolean value);

        public boolean getRemDivergentIsPrior();

        public void setRemDivergentIsPrior(boolean value);

        public boolean getRemStraightIsPrior();

        public void setRemStraightIsPrior(boolean value);

        public boolean getRemTopIsPrior();

        public void setRemTopIsPrior(boolean value);

        public List<SCITurnoutListener> getListeners();

    }

    public interface SCITurnoutListener {

        public void onSectionAllowedToRaised(long value);

        public void onSectionLockedToRaised(long value);

        public void onSectionLockedWithReplyToRaised(long value);

        public void onLockRequestToRaised(long value);

        public void onRemShortPassageRequestToRaised(long value);

        public void onRemPassageAllowedToRaised(long value);

        public void onRemPassageDeniedToRaised(long value);

        public void onRemPassageRequestToRaised(long value);
    }

    public SCITurnout getSCITurnout();

}
