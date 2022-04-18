package gr.codehub.jakartaeshop.repository;

import gr.codehub.jakartaeshop.model.Employee;

import java.util.Optional;

public interface EmployeeRepository {
    Optional<Employee> save(Employee employee);
    Optional<Employee> findById(int id);
}
