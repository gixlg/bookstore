package it.gixlg.bookstore;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
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


    @Nested
    class OldTest {
        @Test
        void shouldIncreasePointsByDepositingABook() {
            Account account = new Account(0);
            account.deposit();
            assertThat(account.getPoints()).isEqualTo(1);
        }
        @Test
        void shouldGetBonusWhenDepositing() {
            Account account = new Account(10);
            account.deposit();
            assertThat(account.getPoints()).isEqualTo(12);
        }
        @Test
        void shouldDecreasePointsByWithdrawABook() throws WithdrawException {
            Account account = new Account(3);
            account.withdraw();
            assertThat(account.getPoints()).isEqualTo(1);
        }
        @Test
        void shouldWithdrawWithDiscount() throws WithdrawException {
            Account account = new Account(5);
            account.withdraw();
            assertThat(account.getPoints()).isEqualTo(4);
        }
        @Test
        void shouldAvoidToWithdrawWhenThereAreNoMoney() {
            Account account = new Account(1);
            ThrowableAssert throwableAssert = assertThatThrownBy(() -> account.withdraw());
            throwableAssert.isInstanceOf(WithdrawException.class);
            assertThat(account.getPoints()).isEqualTo(1);
        }
    }


}
