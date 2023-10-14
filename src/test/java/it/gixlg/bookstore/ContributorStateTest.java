package it.gixlg.bookstore;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

class ContributorStateTest {

    ContributorState state;
    Account account = mock(Account.class);

    @BeforeEach
    void setUp() {
        state = new ContributorState(account);
    }

    @Test
    void shouldDeposit() {
        when(account.getPoints()).thenReturn(1);

        state.deposit();

        verify(account).setPoints(2);
    }

    @Test
    void shouldWithdraw() {
        when(account.getPoints()).thenReturn(1);

        ThrowableAssert throwableAssert =
                assertThatThrownBy(
                        () -> state.withdraw()
                );
        throwableAssert
                .isInstanceOf(WithdrawException.class);
    }
}
