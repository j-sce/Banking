package bankingApp.consoleUI;

import bankingApp.domain.BankAccount;
import bankingApp.repository.BankAccountRepository;

import java.util.Scanner;

public class AddBankAccountUIAction implements UIAction {

    private final BankAccountRepository bankAccountRepository;

    public AddBankAccountUIAction(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @Override
    public void execute() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter bank account balance: ");
            double balance = Double.parseDouble(scanner.nextLine());
            BankAccount bankAccount = new BankAccount(balance);
            bankAccountRepository.save(bankAccount);
            System.out.println("Bank Account added successfully!");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter a valid balance.");
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }
    }

}