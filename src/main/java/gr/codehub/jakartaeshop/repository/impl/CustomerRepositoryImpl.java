/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.jakartaeshop.repository.impl;

import gr.codehub.jakartaeshop.model.Basket;
import gr.codehub.jakartaeshop.model.Customer;
import gr.codehub.jakartaeshop.repository.CustomerRepository;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author iracl
 */
public class CustomerRepositoryImpl extends RepositoryImpl<Customer> implements CustomerRepository{

      @PersistenceContext(unitName = "Persistence")
    private EntityManager em;
    
    
    @Override
    public Class<Customer> getClassType() {
        return Customer.class;
    }

    @Override
    public String getClassName() {
        return Customer.class.getName();
    }

    @Override
    public void copyValues(Customer tTarget, Customer tSource) {
         tTarget.setName(tSource.getName());
    }

    @Override
    public Optional<Customer> update(int id, Customer t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Basket> findCustomerWithBaskets(int customerId) {
        
       return (  em.createQuery("from Basket b "
               + "  where b.customer.id = :customerId")
               .setParameter("customerId", customerId).getResultList());
    }
}
