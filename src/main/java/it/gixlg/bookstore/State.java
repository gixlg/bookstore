package it.gixlg.bookstore;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class State {

    protected Account account;

    public abstract void deposit();

    public abstract void withdraw() throws WithdrawException;

}

