package bankingApp.consoleUI;

import bankingApp.repository.BankAccountRepository;

import java.util.Scanner;

public class DepositToBankAccountUIAction implements UIAction {

    private final BankAccountRepository bankAccountRepository;

    public DepositToBankAccountUIAction(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @Override
    public void execute() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter bank account ID: ");
            long id = Long.parseLong(scanner.nextLine());
            System.out.println("Enter deposit amount: ");
            double amount = Double.parseDouble(scanner.nextLine());
            bankAccountRepository.findById(id).ifPresent(bankAccount -> {
                bankAccount.deposit(amount);
                System.out.println("Deposit successful! Deposited: " + amount);
            });
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter a valid ID and amount.");
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }
    }

}
