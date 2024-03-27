public class BankAccount {
    private double balance;

    public BankAccount() {
    }

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void deposit(double depositAmount) {
        balance = balance + depositAmount;
    }

    public void withdraw(double withdrawAmount) {
        if (withdrawAmount <= balance) {
            balance = balance - withdrawAmount;
        } else {
            System.out.println("Withdraw failed, please check your balance!");
        }
    }

    public void printBalance() {
        System.out.println("Current Balance: " + balance);
    }

    public void transfer(BankAccount transferTo, double transferAmount) {
        if (transferAmount <= balance) {
            withdraw(transferAmount);
            transferTo.deposit(transferAmount);
            System.out.println("Transfer successful! Transferred: " + transferAmount + ".");
        } else {
            System.out.println("Transfer failed, please check your balance!");
        }
    }
}
