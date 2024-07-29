import java.util.Objects;

public class BankAccount {
    String accountNumber;
    String accountHolderName;
    Double balance;

    public BankAccount(String accountNumber, String accountHolderName, Double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccount that = (BankAccount) o;
        return Objects.equals(accountNumber, that.accountNumber) && Objects.equals(accountHolderName, that.accountHolderName) && Objects.equals(balance, that.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, accountHolderName, balance);
    }

    @Override
    public String toString() {
        return "BankAccount {" +
                "accountNumber=" + accountNumber +
                ", accountHolderName='" + accountHolderName + '\'' +
                ", balance=" + balance +
                '}';
    }

    synchronized void deposit(Double amount){
        if(this.getBalance() >=amount){
            balance=this.getBalance() +amount;
            System.out.println("Deposited Rs."+amount+", Balance after deposit transaction: "+balance);
        }
    }

    synchronized void withdrawal( Double amount) throws ExceptionHandler.InsuffientBalanceException {
        if(this.getBalance() >=amount){
            balance=this.getBalance() - amount;
            System.out.println("Withdrawal Rs."+amount+", Balance after withdrawal transaction: "+balance);
        }else{
            throw new ExceptionHandler.InsuffientBalanceException("Insufficient balance, Amount cannot be debited");
        }
    }

    public static void main(String[] args) {

        BankAccount bank=new BankAccount("SBIN2345677", "Shruthi Mohan",3000.45);
        System.out.println(bank.toString());

        Deposit deposit=new Deposit(bank,2000.23);
        Thread threadDeposit=new Thread(deposit);
        threadDeposit.start();

        Withdrawal withdrawal=new Withdrawal(bank,2200.90);
        Thread threadWithdrawal=new Thread(withdrawal);
        threadWithdrawal.start();
    }}
