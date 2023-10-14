package it.gixlg.bookstore;

import lombok.AccessLevel;
import lombok.Getter;

public class Account {

    @Getter(AccessLevel.PROTECTED)
    private int points;

    Account(int points) {
        this.points = points;
    }

    public void deposit() {

    }

    public void withdraw() throws WithdrawException {

    }
}
