@Service
public class TransactionService {

    @Autowired
    private AccountRepository repo;

    public String deposit(String accNo, double amount) {
        Account acc = repo.findByAccountNumber(accNo).orElseThrow();
        acc.setBalance(acc.getBalance() + amount);
        repo.save(acc);
        return "Deposit successful";
    }

    public String withdraw(String accNo, double amount) {
        Account acc = repo.findByAccountNumber(accNo).orElseThrow();

        if (acc.getBalance() < amount) {
            throw new RuntimeException("Insufficient Balance");
        }

        acc.setBalance(acc.getBalance() - amount);
        repo.save(acc);
        return "Withdraw successful";
    }

    public String transfer(String from, String to, double amount) {
        Account sender = repo.findByAccountNumber(from).orElseThrow();
        Account receiver = repo.findByAccountNumber(to).orElseThrow();

        if (sender.getBalance() < amount) {
            throw new RuntimeException("Insufficient Balance");
        }

        sender.setBalance(sender.getBalance() - amount);
        receiver.setBalance(receiver.getBalance() + amount);

        repo.save(sender);
        repo.save(receiver);

        return "Transfer successful";
    }
}
