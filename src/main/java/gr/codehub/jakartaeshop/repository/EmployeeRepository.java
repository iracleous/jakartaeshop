package gr.codehub.jakartaeshop.repository;

import gr.codehub.jakartaeshop.model.Employee;
import java.util.List;

import java.util.Optional;

public interface EmployeeRepository extends Repository<Employee>{
   Optional<Employee> findByName(String name);
   Optional<Employee> update(int id, Employee employee);
   
}
