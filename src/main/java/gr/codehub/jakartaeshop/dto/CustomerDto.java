package gr.codehub.jakartaeshop.dto;


 
import gr.codehub.jakartaeshop.model.Customer;
import java.sql.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

 

@Data
@NoArgsConstructor
public class CustomerDto {

    private int id;
    private String name;
    private Date regDate;
    private int age;
    private String email;


    public CustomerDto(Customer customer){
        id = customer.getId();
        name = customer.getName();
        regDate = customer.getRegDate();
        age = customer.getAge();
        email = customer.getEmail();
    }

    public Customer createCustomer(){
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName(name);
        customer.setRegDate(regDate);
        customer.setAge(age);
        customer.setEmail(email);
        return customer;
    }

}
