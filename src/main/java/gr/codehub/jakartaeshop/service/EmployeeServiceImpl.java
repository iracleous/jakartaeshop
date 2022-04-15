package gr.codehub.jakartaeshop.service;

import gr.codehub.jakartaeshop.model.Employee;
import gr.codehub.jakartaeshop.repository.EmployeeRepository;
import jakarta.inject.Inject;

public class EmployeeServiceImpl implements  EmployeeService{

    @Inject
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(int id) {
        Employee employee = new Employee();
        employee.setId(id);
        employee.setName("No name");
        employeeRepository.save(employee);
        return employee;
    }

    @Override
    public Employee readEmployee(int id) {
        Employee employee = employeeRepository.findById(id);
        return employee;
    }

}
