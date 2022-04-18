package gr.codehub.jakartaeshop.service;

import gr.codehub.jakartaeshop.model.Employee;
import gr.codehub.jakartaeshop.repository.EmployeeRepository;


import javax.inject.Inject;
import java.util.Optional;

public class EmployeeServiceImpl implements  EmployeeService{

    @Inject
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(String name) {
        Employee employee = new Employee();

        employee.setName(name);
        employeeRepository.save(employee);
        return employee;
    }

    @Override
    public Employee readEmployee(int id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) return employee.get();
        Employee empl = new Employee();
        empl.setId(-1);
        return empl;
    }

}
