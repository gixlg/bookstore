package it.gixlg.bookstore;

import static it.gixlg.bookstore.Account.*;

public class ContributorState extends State {

    public ContributorState(Account account) {
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
        throw new WithdrawException();
    }

}
