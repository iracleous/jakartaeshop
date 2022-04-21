package gr.codehub.jakartaeshop.repository.impl;

import gr.codehub.jakartaeshop.model.Employee;
import gr.codehub.jakartaeshop.repository.EmployeeRepository;
 
 
import java.util.Optional;

public class EmployeeRepositoryImpl extends RepositoryImpl<Employee> implements EmployeeRepository{

    
    @Override
    public Class<Employee> getClassType() {
        return Employee.class;
    }

    @Override
    public String getClassName() {
        return Employee.class.getName();
    }

    @Override
    public void copyValues(Employee tSource, Employee tTarget) {
        tTarget.setName(tSource.getName());
    }

    @Override
    public Optional<Employee> findByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
 

