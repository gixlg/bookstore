package it.gixlg.bookstore;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class PremiumStateTest {

    PremiumState state;
    Account account = mock(Account.class);

    @BeforeEach
    void setUp() {
        state = new PremiumState(account);
    }

    @Test
    void shouldDeposit() {
        when(account.getPoints()).thenReturn(10);

        state.deposit();

        verify(account).setPoints(12);
    }

    @Test
    void shouldWithdraw() throws WithdrawException {
        when(account.getPoints()).thenReturn(15);

        state.withdraw();

        verify(account).setPoints(14);
    }
}
