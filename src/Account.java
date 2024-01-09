public class Account {
    private String name;
    private double balance;
    private Customer customer;
    public Account(String name, Customer customer) {
        this.name = name;
        this.customer = customer;
        this.balance = 0;
    }

    public void deposit(double money) {
        balance += money;
    }

    public void withdraw(double money) {
        balance -= money;
    }
}
