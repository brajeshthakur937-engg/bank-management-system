@Service
public class AccountService {

    @Autowired
    private AccountRepository repo;

    public Account createAccount(Account account) {
        account.setBalance(0);
        return repo.save(account);
    }

    public double getBalance(String accNo) {
        return repo.findByAccountNumber(accNo)
                .orElseThrow(() -> new RuntimeException("Account not found"))
                .getBalance();
    }
}
