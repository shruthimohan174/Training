import javax.security.auth.login.AccountNotFoundException;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Account {
    private Integer customerId;
    private String accountNumber;
    private List<String> transactions;
    private Double balance;
    private final AtomicInteger transactionCount=new AtomicInteger(1);

    public Account(Integer customerId, String accountNumber, List<String> transactions, Double balance) {
        this.customerId = customerId;
        this.accountNumber = accountNumber;
        this.transactions = transactions;
        this.balance = balance;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public List<String> getTransactions() {
        return transactions;
    }

    public Double getBalance() {
        return balance;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setTransactions(List<String> transactions) {
        this.transactions = transactions;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public void creditAmount( Double amount)  {

        this.balance+=amount;
        addTransaction("Credited Rs. "+amount+" Balance left: "+this.getBalance());
    }

    public void debitAmount(Double amount) throws ExceptionHandler.InsuffientBalanceException {

        if(amount>balance){
            throw new ExceptionHandler.InsuffientBalanceException();
        }
        this.balance-=amount;
        addTransaction("Debited Rs. "+amount+" Balance left: "+this.getBalance());
    }

    public void transferTo(String accountNumber, Double amount,List<Account> accountList) throws ExceptionHandler.AccountNotFoundException, ExceptionHandler.InsuffientBalanceException {

        Account transferAccount = accountList.stream().filter(account ->
                        account.getAccountNumber().equals(accountNumber))
                .findAny().orElseThrow(ExceptionHandler.AccountNotFoundException::new);

        this.debitAmount(amount);
        transferAccount.creditAmount(amount);

        addTransaction("Transferred Rs. "+amount+" to account "+transferAccount.getAccountNumber());
        transferAccount.addTransaction("Received Rs. "+amount+" from account "+this.getAccountNumber());
    }

    public void addTransaction(String transactionDetails){
        int count=transactionCount.getAndIncrement();
        transactions.add(count+" "+transactionDetails);
    }
    public void displayAllTransactions(List<Customer> customerList) {
        String customerName= getCustomerName(this.customerId,customerList);

        System.out.println("\nTransaction history of "+customerName);
        transactions.stream().forEach(System.out::println);
    }

    public String getCustomerName(Integer customerId,List<Customer> customerList){
      return  customerList.stream().filter(customer -> customer.getCustomerId().equals(customerId))
                .findAny().map(customer -> customer.getFirstName()+" "+customer.getLastName())
                .orElse("Customer Not Found");
    }

    @Override
    public String toString() {
        return "Account{" +
                "customerId=" + customerId +
                ", accountNumber='" + accountNumber + '\'' +
                ", transactions=" + transactions +
                ", balance=" + balance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account account)) return false;
        return Objects.equals(customerId, account.customerId) && Objects.equals(accountNumber, account.accountNumber) && Objects.equals(transactions, account.transactions) && Objects.equals(balance, account.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, accountNumber, transactions, balance);
    }

}

