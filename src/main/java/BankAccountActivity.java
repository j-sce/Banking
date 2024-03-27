public class BankAccountActivity {

    public static void main(String[] args) {
        BankAccount bankAccount1 = new BankAccount(100);
        BankAccount bankAccount2 = new BankAccount(35);
        printBalances(bankAccount1, bankAccount2);
        System.out.println("\nDeposit 300 to Bank account 1:");
        bankAccount1.deposit(300);
        printBalances(bankAccount1, bankAccount2);
        System.out.println("\nWithdraw 10 from Bank account 2:");
        bankAccount2.withdraw(10);
        printBalances(bankAccount1, bankAccount2);
        System.out.println("\nWithdraw 100 (insufficient amount) from Bank account 2:");
        bankAccount2.withdraw(100);
        printBalances(bankAccount1, bankAccount2);
        System.out.println("\nTransfer 100 from Bank account 1 to Bank account 2:");
        bankAccount1.transfer(bankAccount2, 100);
        printBalances(bankAccount1, bankAccount2);
        System.out.println("\nTransfer 300 insufficient amount) from Bank account 2 to Bank account 1:");
        bankAccount2.transfer(bankAccount1, 300);
        printBalances(bankAccount1, bankAccount2);
    }

    private static void printBalances(BankAccount bankAccount1, BankAccount bankAccount2) {
        System.out.println("Bank account 1:");
        bankAccount1.printBalance();
        System.out.println("Bank account 2:");
        bankAccount2.printBalance();
    }
}
