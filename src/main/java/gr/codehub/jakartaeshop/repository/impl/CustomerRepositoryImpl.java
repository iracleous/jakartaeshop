/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.jakartaeshop.repository.impl;

import gr.codehub.jakartaeshop.model.Customer;
import gr.codehub.jakartaeshop.repository.CustomerRepository;
import gr.codehub.jakartaeshop.repository.impl.RepositoryImpl;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author iracl
 */
public class CustomerRepositoryImpl extends RepositoryImpl<Customer> implements CustomerRepository{

    @Override
    public Class<Customer> getClassType() {
        return Customer.class;
    }

    @Override
    public String getClassName() {
        return Customer.class.getName();
    }

    @Override
    public void copyValues(Customer tSource, Customer tTarget) {
         tTarget.setName(tSource.getName());
    }

    @Override
    public Optional<Customer> update(int id, Customer t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
