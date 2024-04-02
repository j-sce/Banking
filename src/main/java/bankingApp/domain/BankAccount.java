package bankingApp.domain;

public class BankAccount {

    private long id;
    private double balance;

    public BankAccount() {
    }

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void deposit(double depositAmount) {
        balance += depositAmount;
    }

    public boolean withdraw(double withdrawAmount) {
        if (withdrawAmount <= balance) {
            balance -= withdrawAmount;
            return true;
        } else {
            System.out.println("Withdraw failed, please check your balance!");
            return false;
        }
    }

    public void printBalance() {
        System.out.println("Current Balance: " + balance);
    }

    public void transfer(BankAccount transferTo, double transferAmount) {
        if (withdraw(transferAmount)) {
            transferTo.deposit(transferAmount);
            System.out.println("Transfer successful! Transferred: " + transferAmount + ".");
        } else {
            System.out.println("Transfer failed, please check your balance!");
        }
    }

    public long getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BankAccount that)) return false;

        if (id != that.id) return false;
        return Double.compare(that.balance, balance) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (id ^ (id >>> 32));
        temp = Double.doubleToLongBits(balance);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "id=" + id +
                ", balance=" + balance +
                '}';
    }

}