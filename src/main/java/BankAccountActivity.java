import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankAccountActivity {

    public static void main(String[] args) {
        BankAccountRepository bankAccountRepository = new InMemoryBankAccountRepository();
        List<BankAccount> bankAccounts = new ArrayList<>();

        while (true) {
            printAppMenu();
            int userChoice = getMenuNumberFromUser();
            executeSelectedMenuItem(bankAccountRepository, userChoice);
        }

    }

    private static void printAppMenu() {
        System.out.println("Application menu:");
        System.out.println("1. Add Bank Account to the list");
        System.out.println("2. Delete Bank Account from the list");
        System.out.println("3. Show all Bank Accounts");
        System.out.println("4. Show all Bank Accounts' balances");
        System.out.println("5. Deposit to Bank Account");
        System.out.println("6. Withdraw from bank Account");
        System.out.println("7. Transfer funds");
        System.out.println("8. Exit");
        System.out.println();
    }

    private static int getMenuNumberFromUser() {
        System.out.println("Enter menu item number to execute:");
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine()); // TODO NumberFormatException
    }

    private static void executeSelectedMenuItem(BankAccountRepository bankAccountRepository, int userChoice) {
        switch (userChoice) {
            case 1 -> {
                addNewBankAccount(bankAccountRepository);
            }
            case 2 -> {
                deleteBankAccount(bankAccountRepository);
            }
            case 3 -> {
                printAllBankAccounts(bankAccountRepository);
            }
            case 4 -> {
                printBalances(bankAccountRepository);
            }
            case 5 -> {
                depositToBankAccount(bankAccountRepository);
            }
            case 6 -> {
                withdrawFromBankAccount(bankAccountRepository);
            }
            case 7 -> {
                transferBetweenBankAccounts(bankAccountRepository);
            }
            default -> {
                exit();
            }
        }

    }

    private static void addNewBankAccount(BankAccountRepository bankAccountRepository) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter bank account balance: ");
        int balance = scanner.nextInt();
        BankAccount bankAccount = new BankAccount(balance);
        bankAccountRepository.save(bankAccount);
    }

    private static void deleteBankAccount(BankAccountRepository bankAccountRepository) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter bank account balance: ");
        int balance = scanner.nextInt();
        BankAccount bankAccount = new BankAccount(balance);
        bankAccountRepository.delete(bankAccount);
    }

    private static void printAllBankAccounts(BankAccountRepository bankAccountRepository) {
        System.out.println("Bank Accounts list: ");
        bankAccountRepository.getAllBankAccounts().forEach(System.out::println);
    }

    private static void printBalances(BankAccountRepository bankAccountRepository) {
        bankAccountRepository.getAllBankAccounts().forEach(BankAccount::printBalance);
    }

    private static void depositToBankAccount(BankAccountRepository bankAccountRepository) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter bank account number in List (0...): ");
        int number = scanner.nextInt();
        System.out.println("Enter deposit amount: ");
        int amount = scanner.nextInt();
        bankAccountRepository.getAllBankAccounts().get(number).deposit(amount);
    }

    private static void withdrawFromBankAccount(BankAccountRepository bankAccountRepository) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter bank account number in List (0...): ");
        int number = scanner.nextInt();
        System.out.println("Enter withdraw amount: ");
        int amount = scanner.nextInt();
        bankAccountRepository.getAllBankAccounts().get(number).withdraw(amount);
    }

    private static void transferBetweenBankAccounts(BankAccountRepository bankAccountRepository) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter bank account number to send from in List (0...): ");
        int senderNumber = scanner.nextInt();
        System.out.println("Enter bank account number to send to in List (0...): ");
        int receiverNumber = scanner.nextInt();
        System.out.println("Enter transfer amount: ");
        int amount = scanner.nextInt();
        bankAccountRepository.getAllBankAccounts().get(senderNumber).transfer(bankAccountRepository.getAllBankAccounts().get(receiverNumber), amount);
    }

    private static void exit() {
        System.exit(0);
    }
}
