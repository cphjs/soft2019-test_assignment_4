package cphb;

/**
 * Customer
 */
public class Customer {

    private String name;
    private Account account;

    public Customer(String name) {
        this.name = name;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param account the account to set
     */
    public void setAccount(Account account) {
        this.account = account;
    }

    /**
     * @return the account
     */
    public Account getAccount() {
        return account;
    }
}