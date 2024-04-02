package bankingApp.repository;

import bankingApp.domain.BankAccount;

import java.util.List;
import java.util.Optional;

public interface BankAccountRepository {

    void save(BankAccount bankAccount);

    void deleteByID(long id);

    List<BankAccount> getAllBankAccounts();

    Optional<BankAccount> findById(long id);

}