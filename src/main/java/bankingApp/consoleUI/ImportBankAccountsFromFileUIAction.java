package bankingApp.consoleUI;

import bankingApp.domain.BankAccount;
import bankingApp.repository.BankAccountRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ImportBankAccountsFromFileUIAction implements UIAction {

    private final BankAccountRepository bankAccountRepository;

    public ImportBankAccountsFromFileUIAction(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @Override
    public void execute() {
        try (BufferedReader reader = new BufferedReader(new FileReader("bank_accounts.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                long id = Long.parseLong(parts[0]);
                double balance = Double.parseDouble(parts[1]);
                BankAccount bankAccount = new BankAccount(balance);
                bankAccount.setId(id);
                bankAccountRepository.save(bankAccount);
            }
            System.out.println("Bank accounts have been imported from bank_accounts.txt successfully.");
        } catch (IOException e) {
            System.out.println("Error occurred while importing bank accounts from file: " + e.getMessage());
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Invalid format in bank_accounts.txt file.");
        }
    }

}