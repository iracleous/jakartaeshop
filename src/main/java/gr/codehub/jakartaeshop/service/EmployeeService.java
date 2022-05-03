package gr.codehub.jakartaeshop.service;

import gr.codehub.jakartaeshop.dto.EmployeeDto;

 

public interface EmployeeService {

    EmployeeDto saveEmployee(String name);
    EmployeeDto  readEmployee(int id);
    EmployeeDto  updateEmployee(int employeeId, EmployeeDto employeeDto);
    boolean deleteEmployee(int employeeId);
}
