package bankingApp.consoleUI;

import bankingApp.repository.BankAccountRepository;

public class PrintAllBankAccountsUIAction implements UIAction {

    private final BankAccountRepository bankAccountRepository;

    public PrintAllBankAccountsUIAction(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @Override
    public void execute() {
        System.out.println("Bank Accounts list: ");
        bankAccountRepository.getAllBankAccounts().forEach(System.out::println);
    }

}