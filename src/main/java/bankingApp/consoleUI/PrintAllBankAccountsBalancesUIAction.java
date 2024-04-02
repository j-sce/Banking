package bankingApp.consoleUI;

import bankingApp.domain.BankAccount;
import bankingApp.repository.BankAccountRepository;

public class PrintAllBankAccountsBalancesUIAction implements UIAction {

    private final BankAccountRepository bankAccountRepository;

    public PrintAllBankAccountsBalancesUIAction(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @Override
    public void execute() {
        bankAccountRepository.getAllBankAccounts().forEach(BankAccount::printBalance);
    }

}