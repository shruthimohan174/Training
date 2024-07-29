import javax.security.auth.login.AccountNotFoundException;
import java.util.List;
import java.util.Objects;

public class Account {
    private Integer customerId;
    private Integer accountNumber;
    private List<String> transactions;
    private Double balance;

    public Account(Integer customerId, Integer accountNumber, List<String> transactions, Double balance) {
        this.customerId = customerId;
        this.accountNumber = accountNumber;
        this.transactions = transactions;
        this.balance = balance;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public Integer getAccountNumber() {
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

    public void setAccountNumber(Integer accountNumber) {
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
        transactions.add("Credited Rs."+amount+", Balance left "+ getBalance());
    }


    public void debitAmount(Double amount) throws ExceptionHandler.InsuffientBalanceException {

        if(amount>balance){
            throw new ExceptionHandler.InsuffientBalanceException();
        }
        this.balance-=amount;
        transactions.add("Debited Rs."+amount+", Balance left: "+ getBalance());
    }

    public void transferTo(Integer accountNumber, Double amount,List<Account> accountList) throws ExceptionHandler.AccountNotFoundException, ExceptionHandler.InsuffientBalanceException {
        for(Account account : accountList) {
            if(account.getAccountNumber().equals(accountNumber)){
                this.debitAmount(amount);
                account.creditAmount(amount);

                transactions.add("Transferred: Rs."+amount+" from account "+this.accountNumber+" to account: "
                        +account.accountNumber+" Balance left after transaction:"+this.getBalance());

                account.transactions.add("Received Rs."+amount+" from account "+this.getAccountNumber()+
                " to account: "+account.accountNumber+" Balance left after transaction:"+account.getBalance());
               return;
            }
        }throw new ExceptionHandler.AccountNotFoundException();
    }

    public void displayAllTransactions(List<Customer> customerList) {
        String customerName= getCustomerName(this.customerId,customerList);

        System.out.println("\nTransaction history of "+customerName);
//        for(String transaction: transactions){
//            System.out.println(transaction);
//        }

        transactions.stream().forEach(System.out::println);
    }
    public String getCustomerName(Integer customerId,List<Customer> customerList){
        String customerName="";
        for(Customer customer : customerList){
            if(customer.getCustomerId().equals(customerId)){
                 customerName=customer.getFirstName()+" "+customer.getLastName();
                 break;
            }
        }
        return customerName;
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

