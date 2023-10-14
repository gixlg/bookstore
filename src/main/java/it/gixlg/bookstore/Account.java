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

    Account(int points) {
        this.points = points;
    }

    public void deposit() {
        if (points >= THRESHOLD_BONUS) {
            points = points + BONUS;
        }
        points = points + STANDARD_POINT_FOR_DEPOSIT;
    }

    public void withdraw() throws WithdrawException {
        if (points <= THRESHOLD_WITHDRAW) throw new WithdrawException();
        if (points >= THRESHOLD_DISCOUNT) {
            points = points + DISCOUNT;
        }
        points = points - STANDARD_POINTS_FOR_WITHDRAW;


    }
}
