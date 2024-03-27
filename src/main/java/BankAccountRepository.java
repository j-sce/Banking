import java.util.List;

public interface BankAccountRepository {

    void save(BankAccount bankAccount);

    void delete(BankAccount bankAccount);

    List<BankAccount> getAllBankAccounts();
}
