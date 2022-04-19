package gr.codehub.jakartaeshop.repository;

import gr.codehub.jakartaeshop.model.Employee;
import gr.codehub.jakartaeshop.repository.impl.RepositoryImpl;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
 

