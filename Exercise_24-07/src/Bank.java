import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Bank {
    public void transactionHandler(Account account,Double amount,String symbol){
        if(Objects.equals(symbol, "+"))
            account.creditAmount(amount);
        else
            try{
                account.debitAmount(amount);
            }
            catch (ExceptionHandler.InsuffientBalanceException e) {
                System.out.println("Exception: "+e.getMessage());
            }
    }

    public void transferToMethod(Account account,String accountNumber, Double amount, List<Account>accountList){
        try{
            account.transferTo(accountNumber,amount,accountList);
        }catch (ExceptionHandler.InsuffientBalanceException | ExceptionHandler.AccountNotFoundException e) {
            System.out.println("Exception: "+e.getMessage());
        }
    }

    public static void main(String[] args)  {
        Bank bank=new Bank();
        List<Customer> customerList= new ArrayList<>();
        Customer c1 = new Customer(1, "Shruthi", "Mohan", Gender.FEMALE);
        Customer c2 = new Customer(2, "Shilpa", "Mehta", Gender.MALE);
        Customer c3 = new Customer(3, "Rajesh", "Raj", Gender.MALE);

        customerList.add(c1);
        customerList.add(c2);
        customerList.add(c3);

        c1.fetchGenderNames();
        c1.countGender(customerList);

        System.out.println("\nCustomer Details: ");
        customerList.stream().map(customer ->
                customer.toString()).forEach(System.out::println);

        Account account1=new Account(1,"SBIN312228",new ArrayList<>(),40000.34);
        Account account2=new Account(2,"SBIN4234232",new ArrayList<>(),25000.34);
        List<Account> accountList=new ArrayList<>();
        accountList.add(account1);
        accountList.add(account2);

        System.out.println("\nAccount Details: ");
        accountList.stream().map(account ->
                account.toString()).forEach(System.out::println);

        bank.checkCustomerAccounts(customerList,accountList);

        bank.transactionHandler(account2,100.56,"-");
        bank.transactionHandler(account1,100.56,"+");
        bank.transferToMethod(account1,"SBIN4234232",2000.00,accountList);

            System.out.println("\nTransaction Details: ");
            account1.displayAllTransactions(customerList);
            account2.displayAllTransactions(customerList);
    }

    public void checkCustomerAccounts(List<Customer> customerList, List<Account> accountList) {
        List<Integer> accountCustomerId=accountList.stream().map(Account::getCustomerId).collect(Collectors.toList());

        customerList.stream().forEach(customer ->
                System.out.println("Customer: " + customer.getFirstName() + " " + customer.getLastName() +
                        (accountCustomerId.contains(customer.getCustomerId()) ? " has a bank account" : " has no bank account")
                ));
    }
}
