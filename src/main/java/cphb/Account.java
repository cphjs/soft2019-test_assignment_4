package cphb;

/**
 * Account
 */
public class Account {

    private double balance;
    private Customer customer;

    public Account(Customer customer) {
        this.customer = customer;
        this.customer.setAccount(this);
    }

    /**
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * @param customer the customer to set
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * @return the balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * @param balance the balance to set
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0");
        }
        setBalance(getBalance() + amount);
    }

    public void withdraw(double amount) {
        double balance = getBalance();
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Amount cannot be higher than the balance");
        }
        setBalance(balance - amount);
    }

    public double getInterest() {
        double balance = getBalance();
        if (balance >= 0 && balance < 100) {
            return balance / 100 * 3;
        } else if (balance >= 100 && balance < 1000) {
            return balance / 100 * 5;
        } else if (balance >= 1000) {
            return balance / 100 * 7;
        } else {
            throw new IllegalArgumentException("Balance cannot be lower than 0");
        }
    }
}