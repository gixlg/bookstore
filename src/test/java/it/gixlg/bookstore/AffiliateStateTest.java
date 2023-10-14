package it.gixlg.bookstore;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class AffiliateStateTest {

    AffiliateState state;
    Account account = mock(Account.class);

    @BeforeEach
    void setUp() {
        state = new AffiliateState(account);
    }

    @Test
    void shouldDeposit() {
        when(account.getPoints()).thenReturn(5);

        state.deposit();

        verify(account).setPoints(6);
    }

    @Test
    void shouldWithdraw() throws WithdrawException {
        when(account.getPoints()).thenReturn(9);

        state.withdraw();

        verify(account).setPoints(8);
    }
}
