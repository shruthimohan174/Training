import java.util.Objects;

public class Deposit implements Runnable{
    BankAccount bankAccount;
    Double amount;

    public Deposit(BankAccount bankAccount, Double amount) {
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
        Deposit deposit = (Deposit) o;
        return Objects.equals(bankAccount, deposit.bankAccount) && Objects.equals(amount, deposit.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bankAccount, amount);
    }

    @Override
    public String toString() {
        return "Deposit{" +
                "bankAccount=" + bankAccount +
                ", amount=" + amount +
                '}';
    }

    @Override
    public void run() {
        for(int i=0;i<3;i++){
            bankAccount.deposit(amount);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("Exception: "+e.getMessage());
            }
        }
    }

}
