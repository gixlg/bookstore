package it.gixlg.bookstore;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class AccountTest {

    private final State state = mock(State.class);
    private Account account;

    @BeforeEach
    void setUp() {
        account = new Account(0);
        account.setState(state);
    }

    @Test
    void shouldCallDeposit() {
        account.deposit();

        verify(state).deposit();
    }

    @Test
    void shouldCallWithdraw() throws WithdrawException {
        account.withdraw();

        verify(state).withdraw();
    }


}
