package it.gixlg.bookstore;

import static it.gixlg.bookstore.Account.*;

public class CommunityState extends State {

    public CommunityState(Account account) {
        super(account);
    }

    @Override
    public void deposit() {
        this.account.setPoints(
                this.account.getPoints()
                        + STANDARD_POINT_FOR_DEPOSIT

        );
    }

    @Override
    public void withdraw() throws WithdrawException {
        this.account.setPoints(
                this.account.getPoints()
                        - STANDARD_POINTS_FOR_WITHDRAW
        );
    }

}
