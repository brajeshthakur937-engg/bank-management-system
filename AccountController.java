@RestController
@RequestMapping("/api")
public class AccountController {

    @Autowired
    private TransactionService service;

    @PostMapping("/deposit")
    public String deposit(String accNo, double amount) {
        return service.deposit(accNo, amount);
    }

    @PostMapping("/withdraw")
    public String withdraw(String accNo, double amount) {
        return service.withdraw(accNo, amount);
    }

    @PostMapping("/transfer")
    public String transfer(String from, String to, double amount) {
        return service.transfer(from, to, amount);
    }
}
