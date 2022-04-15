package gr.codehub.jakartaeshop.repository;

import gr.codehub.jakartaeshop.model.Employee;

public interface EmployeeRepository {
    void save(Employee employee);
    Employee findById(int id);
}
