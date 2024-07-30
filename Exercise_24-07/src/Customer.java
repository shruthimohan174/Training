import java.util.*;
import java.util.stream.Collectors;

public  class Customer{
    private Integer customerId;
    private String firstName;
    private String lastName;
    private Gender gender;

    public Customer(Integer customerId, String firstName, String lastName, Gender gender) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                '}';
    }

    public void fetchGenderNames(){
        System.out.print("Fetching Gender Names: ");
        for(Gender gender : Gender.values()){
            System.out.print(gender+" ");
        }
    }

            public void countGender(List<Customer> customerList){
                System.out.println("\nGender counts: ");

        customerList.stream().collect(Collectors.groupingBy(
                Customer::getGender,Collectors.counting()
        )).forEach((gender,count)->System.out.println(gender+" "+count));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer customer)) return false;
        return Objects.equals(customerId, customer.customerId) && Objects.equals(firstName, customer.firstName) && Objects.equals(lastName, customer.lastName) && gender == customer.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, firstName, lastName, gender);
    }
}