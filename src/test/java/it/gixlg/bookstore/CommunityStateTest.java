package it.gixlg.bookstore;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class CommunityStateTest {

    CommunityState state;
    Account account = mock(Account.class);

    @BeforeEach
    void setUp() {
        state = new CommunityState(account);
    }

    @Test
    void shouldDeposit() {
        when(account.getPoints()).thenReturn(2);

        state.deposit();

        verify(account).setPoints(3);
    }

    @Test
    void shouldWithdraw() throws WithdrawException {
        when(account.getPoints()).thenReturn(4);

        state.withdraw();

        verify(account).setPoints(2);
    }
}
