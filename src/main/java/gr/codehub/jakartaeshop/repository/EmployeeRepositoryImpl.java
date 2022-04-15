package gr.codehub.jakartaeshop.repository;

import gr.codehub.jakartaeshop.model.Employee;

public class EmployeeRepositoryImpl implements EmployeeRepository{
    @Override
    public void save(Employee employee) {

    }

    @Override
    public Employee findById(int id) {
        return new Employee();
    }
}
