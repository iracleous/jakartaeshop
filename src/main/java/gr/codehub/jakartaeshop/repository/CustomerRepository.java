/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.jakartaeshop.repository;

import gr.codehub.jakartaeshop.model.Basket;
import gr.codehub.jakartaeshop.model.Customer;
import java.util.List;

/**
 *
 * @author iracl
 */
public interface CustomerRepository extends Repository<Customer>{

    public  List<Basket> findCustomerWithBaskets(int customerId);
    
}
