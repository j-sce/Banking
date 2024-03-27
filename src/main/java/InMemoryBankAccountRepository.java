import java.util.ArrayList;
import java.util.List;

public class InMemoryBankAccountRepository implements BankAccountRepository {

    private List<BankAccount> bankAccounts = new ArrayList<>();

    @Override
    public void save(BankAccount bankAccount) {
        bankAccounts.add(bankAccount);
    }

    @Override
    public void delete(BankAccount bankAccount) {
        bankAccounts.remove(bankAccount);
    }

    @Override
    public List<BankAccount> getAllBankAccounts() {
        return bankAccounts;
    }
}
