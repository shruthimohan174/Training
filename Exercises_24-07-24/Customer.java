import java.util.*;

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

    public static void fetchGenderNames(){
        System.out.print("Fetching Gender Names: ");
        for(Gender gender : Gender.values()){
            System.out.print(gender+" ");
        }
    }

    public static void countGender(List<Customer> customerList){
        HashMap<Gender,Integer> map = new HashMap<>();
        for(Customer customer : customerList){
            if(map.containsKey(customer.getGender())){
                map.put(customer.getGender(),map.get(customer.getGender())+1);
            }
            else{
                map.put(customer.getGender(),1);
            }
        }

        System.out.println("\nGender counts: ");
        for(Map.Entry<Gender,Integer> entry : map.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
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