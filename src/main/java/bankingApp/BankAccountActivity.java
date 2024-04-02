package bankingApp;

import bankingApp.consoleUI.*;
import bankingApp.repository.BankAccountRepository;
import bankingApp.repository.InMemoryBankAccountRepository;

import java.util.Scanner;

public class BankAccountActivity {

    private static final BankAccountRepository bankAccountRepository = new InMemoryBankAccountRepository();
    private static final UIAction addBankAccountUIAction = new AddBankAccountUIAction(bankAccountRepository);
    private static final UIAction deleteBankAccountUIAction = new DeleteBankAccountUIAction(bankAccountRepository);
    private static final UIAction printAllBankAccountsUIAction = new PrintAllBankAccountsUIAction(bankAccountRepository);
    private static final UIAction printAllBankAccountsBalancesUIAction = new PrintAllBankAccountsBalancesUIAction(bankAccountRepository);
    private static final UIAction depositToBankAccountUIAction = new DepositToBankAccountUIAction(bankAccountRepository);
    private static final UIAction withdrawFromBankAccountUIAction = new WithdrawFromBankAccountUIAction(bankAccountRepository);
    private static final UIAction transferBetweenBankAccountsUIAction = new TransferBetweenBankAccountsUIAction(bankAccountRepository);
    private static final UIAction exportBankAccountsToFileUIAction = new ExportBankAccountsToFileUIAction(bankAccountRepository);
    private static final UIAction importBankAccountsFromFileUIAction = new ImportBankAccountsFromFileUIAction(bankAccountRepository);

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                printAppMenu();
                int userChoice = getMenuNumberFromUser(scanner);
                executeSelectedMenuItem(userChoice);
            }
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
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
        System.out.println("8. Export Bank Accounts to file");
        System.out.println("9. Import Bank Accounts from file");
        System.out.println("10. Exit");
        System.out.println();
    }

    private static int getMenuNumberFromUser(Scanner scanner) {
        System.out.println("Enter menu item number to execute:");
        return Integer.parseInt(scanner.nextLine());
    }

    private static void executeSelectedMenuItem(int userChoice) {
        switch (userChoice) {
            case 1 -> addBankAccountUIAction.execute();
            case 2 -> deleteBankAccountUIAction.execute();
            case 3 -> printAllBankAccountsUIAction.execute();
            case 4 -> printAllBankAccountsBalancesUIAction.execute();
            case 5 -> depositToBankAccountUIAction.execute();
            case 6 -> withdrawFromBankAccountUIAction.execute();
            case 7 -> transferBetweenBankAccountsUIAction.execute();
            case 8 -> exportBankAccountsToFileUIAction.execute();
            case 9 -> importBankAccountsFromFileUIAction.execute();
            case 10 -> exit();
            default -> System.out.println("Invalid choice! Please enter a number between 1 and 10.");
        }
    }

    private static void exit() {
        System.exit(0);
    }

}