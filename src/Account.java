public class Account {
    private double balance;
    private Customer customer;
    public Account(Customer customer) {
        this.customer = customer;
        this.balance = 0;
    }

    public void deposit(double money) {
        balance += money;
    }

    public void withdraw(double money) {
        balance -= money;
    }
    public double getBalance(){
        return balance;
    }
}
