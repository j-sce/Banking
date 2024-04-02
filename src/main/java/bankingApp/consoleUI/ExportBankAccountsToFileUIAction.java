package bankingApp.consoleUI;

import bankingApp.domain.BankAccount;
import bankingApp.repository.BankAccountRepository;

import java.io.*;
import java.util.List;

public class ExportBankAccountsToFileUIAction implements UIAction {

    private final BankAccountRepository bankAccountRepository;

    public ExportBankAccountsToFileUIAction(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @Override
    public void execute() {
        try (FileWriter writer = new FileWriter("accounts.csv")) {
            List<BankAccount> bankAccounts = bankAccountRepository.getAllBankAccounts();
            for (BankAccount account : bankAccounts) {
                writer.write(account.getId() + "," + account.getBalance() + "\n");
            }
            System.out.println("Bank accounts have been exported to accounts.csv successfully.");
        } catch (IOException e) {
            System.out.println("Error occurred while exporting bank accounts to file: " + e.getMessage());
        }
    }

}