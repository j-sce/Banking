package bankingApp.consoleUI;

import bankingApp.repository.BankAccountRepository;

import java.util.Scanner;

public class TransferBetweenBankAccountsUIAction implements UIAction {

    private final BankAccountRepository bankAccountRepository;

    public TransferBetweenBankAccountsUIAction(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @Override
    public void execute() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter sender bank account ID: ");
            long senderId = Long.parseLong(scanner.nextLine());
            System.out.println("Enter receiver bank account ID: ");
            long receiverId = Long.parseLong(scanner.nextLine());
            System.out.println("Enter transfer amount: ");
            double amount = Double.parseDouble(scanner.nextLine());
            bankAccountRepository.findById(senderId).ifPresent(sender -> {
                bankAccountRepository.findById(receiverId).ifPresent(receiver -> {
                    sender.transfer(receiver, amount);
                });
            });
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter valid IDs and amount.");
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }
    }

}
