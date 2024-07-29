import java.util.ArrayList;
import java.util.List;

public class Bank {
    public static void creditAmountMethod(Account account,Double amount){
        try{
            account.creditAmount(amount);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void debitAmountMethod(Account account,Double amount){
        try{
            account.debitAmount(amount);
        }catch(Exception e){
            System.out.println("Exception: "+e.getMessage());
        }
    }
    public static void transferToMethod(Account account,Integer accountNumber,Double amount, List<Account> accountList){
        try{
            account.transferTo(accountNumber,amount,accountList);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        List<Customer> customerList= new ArrayList<>();
        customerList.add(new Customer(1,"Shruthi","Mohan",Gender.FEMALE));
        customerList.add(new Customer(2,"Shilpa","Mehta",Gender.MALE));
        customerList.add(new Customer(3,"Rajesh","Raj",Gender.MALE));

        Customer.fetchGenderNames();
        Customer.countGender(customerList);

        System.out.println("\nCustomer Details: ");
        customerList.stream().map(customer ->
                customer.toString()).forEach(System.out::println);

        Account account1=new Account(1,312228,new ArrayList<>(),40000.34);
        Account account2=new Account(2,4234232,new ArrayList<>(),25000.34);
        List<Account> accountList=new ArrayList<>();
        accountList.add(account1);
        accountList.add(account2);

        System.out.println("\nAccount Details: ");
        accountList.stream().map(account ->
                account.toString()).forEach(System.out::println);

        checkCustomerAccounts(customerList,accountList);

        debitAmountMethod(account2,1000000000.56);
        creditAmountMethod(account1,100.56);
            transferToMethod(account1,4234232,2000.00,accountList);

            System.out.println("\nTransaction Details: ");
            account1.displayAllTransactions(customerList);
            account2.displayAllTransactions(customerList);

    }

    public static void checkCustomerAccounts(List<Customer> customerList, List<Account> accountList) {
        List<Integer> accountCustomerId=new ArrayList<>();
        for(Account account:accountList){
            accountCustomerId.add(account.getCustomerId());
        }

        for(Customer customer:customerList){
            if(accountCustomerId.contains(customer.getCustomerId())){
                System.out.println("Customer: "+customer.getFirstName()+" "+customer.getLastName()+" has bank account");
            }
            else{
                System.out.println("Customer: "+customer.getFirstName()+" "+customer.getLastName()+" has no bank account");
            }
        }
    }
}
