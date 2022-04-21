package gr.codehub.jakartaeshop.service;

import gr.codehub.jakartaeshop.dto.EmployeeDto;
import gr.codehub.jakartaeshop.model.Employee;
import gr.codehub.jakartaeshop.repository.EmployeeRepository;


import javax.inject.Inject;
import java.util.Optional;

public class EmployeeServiceImpl implements  EmployeeService{

    @Inject
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto saveEmployee(String name) {
        Employee employee = new Employee();
        employee.setName(name);
        employeeRepository.save(employee);
        return new EmployeeDto(employee);
    }

    @Override
    public EmployeeDto readEmployee(int id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) return new EmployeeDto(employee.get());
        Employee empl = new Employee();
        empl.setId(-1);
        return new EmployeeDto(empl);
    }

}
