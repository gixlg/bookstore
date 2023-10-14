package it.gixlg.bookstore;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class AccountTest {
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
