package gr.codehub.jakartaeshop.repository;

import gr.codehub.jakartaeshop.model.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.Optional;

public class EmployeeRepositoryImpl implements EmployeeRepository{

    @PersistenceContext(unitName="Persistence")
    private EntityManager em;

    @Override
    public Optional<Employee> save(Employee t) {
        try {
            em.getTransaction().begin();
            em.persist(t);
            em.getTransaction().commit();
            return Optional.of(t);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<Employee> findById(int id) {

        Employee t = em.find(Employee.class, id);
        return t != null ? Optional.of(t) : Optional.empty();
    }
}
