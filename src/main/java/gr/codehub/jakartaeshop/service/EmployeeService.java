package gr.codehub.jakartaeshop.service;

import gr.codehub.jakartaeshop.model.Employee;

public interface EmployeeService {

    Employee saveEmployee(String name);
    Employee  readEmployee(int id);
}
