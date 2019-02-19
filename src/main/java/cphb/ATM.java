package cphb;

/**
 * ATM
 */
public class ATM {

    private CreditCard card;

    public void insertCard(CreditCard card) {
        if (this.card != null) throw new ATMException("Cannot insert a second card");
        this.card = card;
    }

    public void ejectCard() {
        this.card = null;
    }

    public boolean isReadyForMoneyOperations() {
        return this.card != null;
    }

    public boolean isAcceptingCards() {
        return this.card == null;
    }

    public void deposit(double amount) {
        if (!isReadyForMoneyOperations()) 
            throw new ATMException("ATM not ready for money operations");
        card.getAccount().deposit(amount);
    }

    public void withdraw(double amount) {
        if (!isReadyForMoneyOperations()) 
            throw new ATMException("ATM not ready for money operations");
        card.getAccount().withdraw(amount);
    }
    
    class ATMException extends RuntimeException {
        public ATMException(String message) {
            super(message);
        }
    }
}