package cphb;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import cphb.ATM.ATMException;

import static org.hamcrest.core.Is.is;

/**
 * ATMTest
 */
public class ATMTest {

    private ATM atm;

    @BeforeEach
    public void setUp() {
        atm = new ATM();
    }

    @Test
    public void testInsertCard_with_no_card_inserted() {
        CreditCard card = makeCard();
        atm.insertCard(card);
        assertThat(atm.isReadyForMoneyOperations(), is(true));
        assertThat(atm.isAcceptingCards(), is(false));
    }

    @Test
    public void testInsertCard_with_a_card_already_inserted() {
        atm.insertCard(makeCard());
        assertThrows(ATMException.class, () -> atm.insertCard(makeCard()));
    }

    /**
     * Making this repeated is pretty pointless but oh well...
     */
    @RepeatedTest(5)
    public void testEjectCard_with_no_card_inserted_works_consistently() {
        atm.ejectCard();
        assertThat(atm.isAcceptingCards(), is(true));
    }

    @Test
    public void testEjectCard_with_card_inserted() {
        atm.insertCard(makeCard());
        atm.ejectCard();
        assertThat(atm.isAcceptingCards(), is(true));
    }

    @Test
    public void testDeposit_with_card_inserted_and_valid_amount() {
        CreditCard card = makeCard();
        card.getAccount().setBalance(10);
        atm.insertCard(card);
        atm.deposit(1);
        assertThat(atm.isReadyForMoneyOperations(), is(true));
    }

    @Test
    public void testDeposit_with_no_card_inserted() {
        assertThrows(ATMException.class, () -> atm.deposit(10));
        assertThat(atm.isReadyForMoneyOperations(), is(false));
    }

    @Test
    public void testWithdraw_with_card_inserted_and_valid_amount() {
        CreditCard card = makeCard();
        card.getAccount().setBalance(10);
        atm.insertCard(card);
        atm.withdraw(1);
        assertThat(atm.isReadyForMoneyOperations(), is(true));
    }

    @Test
    public void testWithdraw_with_no_card_inserted() {
        assertThrows(ATMException.class, () -> atm.withdraw(10));
        assertThat(atm.isReadyForMoneyOperations(), is(false));
    }

    private CreditCard makeCard() {
        Account account = new Account(new Customer("Mrs. Credit Card"));
        return new CreditCard(account);
    }
}