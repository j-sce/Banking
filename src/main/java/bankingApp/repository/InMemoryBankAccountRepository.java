package bankingApp.repository;

import bankingApp.domain.BankAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryBankAccountRepository implements BankAccountRepository {

    private long nextID = 1L;
    private List<BankAccount> bankAccounts = new ArrayList<>();

    @Override
    public void save(BankAccount bankAccount) {
        bankAccount.setId(nextID++);
        bankAccounts.add(bankAccount);
    }

    @Override
    public void deleteByID(long id) {
        bankAccounts.removeIf(account -> account.getId() == id);
    }

    @Override
    public List<BankAccount> getAllBankAccounts() {
        return bankAccounts;
    }

    @Override
    public Optional<BankAccount> findById(long id) {
        return bankAccounts.stream()
                .filter(account -> account.getId() == id)
                .findFirst();
    }

}