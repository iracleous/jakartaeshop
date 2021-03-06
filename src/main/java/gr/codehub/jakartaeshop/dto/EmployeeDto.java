package gr.codehub.jakartaeshop.dto;

 

import gr.codehub.jakartaeshop.model.Employee;
import lombok.Data;
import lombok.NoArgsConstructor;
 


@Data
@NoArgsConstructor
public class EmployeeDto {

    private int id;
    private String name;
     
   public EmployeeDto(Employee employee){
        id = employee.getId();
        name = employee.getName();
        
    }

    public Employee createEmployee(){
        Employee employee = new Employee();
        employee.setId(id);
        employee.setName(name);
      
        return employee;
    }
}
