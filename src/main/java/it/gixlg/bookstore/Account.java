package it.gixlg.bookstore;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

public class Account {

    public static final int THRESHOLD_BONUS = 10;
    public static final int BONUS = 1;
    public static final int STANDARD_POINT_FOR_DEPOSIT = 1;
    public static final int STANDARD_POINTS_FOR_WITHDRAW = 2;
    public static final int THRESHOLD_DISCOUNT = 5;
    public static final int DISCOUNT = 1;
    public static final int THRESHOLD_WITHDRAW = 1;

    @Getter(AccessLevel.PROTECTED)
    @Setter(AccessLevel.PROTECTED)
    private int points;

    @Setter(AccessLevel.PROTECTED)
    private State state = new ContributorState(this);

    Account(int points) {
        this.points = points;
        stateChangeCheck();
    }

    public void deposit() {
        state.deposit();
        stateChangeCheck();
    }

    public void withdraw() throws WithdrawException {
        state.withdraw();
        stateChangeCheck();
    }

    public void stateChangeCheck() {
        this.setState(getCurrentState());
    }

    public State getCurrentState() {
        int points = this.getPoints();
        if (points <= THRESHOLD_WITHDRAW) {
            return new ContributorState(this);
        } else if (points < THRESHOLD_DISCOUNT) {
            return new CommunityState(this);
        } else if (points < THRESHOLD_BONUS) {
            return new AffiliateState(this);
        } else {
            return new PremiumState(this);
        }
    }
}
