/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.jakartaeshop.service;

import gr.codehub.jakartaeshop.dto.CustomerDto;
import gr.codehub.jakartaeshop.dto.CustomerDtoWithBasket;
import java.util.List;

/**
 *
 * @author iracl
 */
public interface CustomerService {
    List<CustomerDto> readCustomer(String productName, String description);
    CustomerDto readCustomer(int productId);
    CustomerDto saveCustomer(CustomerDto product);
    CustomerDto updateCustomer(int productId, CustomerDto product);
    boolean deleteCustomer( int productId );
    
    public CustomerDtoWithBasket readCustomerWithBasket(int customerId);
    
}
