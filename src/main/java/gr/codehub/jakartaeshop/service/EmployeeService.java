package gr.codehub.jakartaeshop.service;

import gr.codehub.jakartaeshop.model.Employee;

public interface EmployeeService {

    Employee saveEmployee(int id);
    Employee  readEmployee(int id);
}
