package bankingApp.consoleUI;

import bankingApp.repository.BankAccountRepository;

import java.util.Scanner;

public class DeleteBankAccountUIAction implements UIAction {

    private final BankAccountRepository bankAccountRepository;

    public DeleteBankAccountUIAction(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @Override
    public void execute() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter bank account ID: ");
            long id = Long.parseLong(scanner.nextLine());
            bankAccountRepository.deleteByID(id);
            System.out.println("Bank Account with ID " + id + " was successfully removed!");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter a valid ID.");
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }
    }

}
