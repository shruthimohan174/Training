import java.util.Objects;

public class Withdrawal implements Runnable{

    BankAccount bankAccount;
    Double amount;

    public Withdrawal(BankAccount bankAccount, Double amount) {
        this.bankAccount = bankAccount;
        this.amount = amount;
    }

    public BankAccount getBackAccount() {
        return bankAccount;
    }

    public void setBackAccount(BankAccount backAccount) {
        this.bankAccount = backAccount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Withdrawal that = (Withdrawal) o;
        return Objects.equals(bankAccount, that.bankAccount) && Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bankAccount, amount);
    }

    @Override
    public String toString() {
        return "Withdrawal{" +
                "bankAccount=" + bankAccount +
                ", amount=" + amount +
                '}';
    }

    @Override
    public void run() {
        try {
            for(int i=0;i<3;i++){
                bankAccount.withdrawal(amount);
                Thread.sleep(1000);

            }
        } catch (ExceptionHandler.InsuffientBalanceException | InterruptedException e) {
            System.out.println("Exception: "+e.getMessage());
        }

    }
}
