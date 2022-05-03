/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.jakartaeshop.service;

import gr.codehub.jakartaeshop.dto.CustomerDto;
import gr.codehub.jakartaeshop.model.Customer;
import gr.codehub.jakartaeshop.repository.CustomerRepository;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;

/**
 *
 * @author iracl
 */
public class CustomerServiceImpl implements CustomerService{

     @Inject
    private CustomerRepository productRepository;
    
    @Override
    public List<CustomerDto> readCustomer(String productName, String description) {
         
             return productRepository.findAll()
                 .stream().map(CustomerDto::new).toList();
            
        
    }

    @Override
    public CustomerDto readCustomer(int productId) {
        
        Optional<Customer> product = productRepository.findById(productId);
        
        if (product.isEmpty()) return null;
        return new CustomerDto(product.get());
    }

    @Override
    public CustomerDto saveCustomer(CustomerDto product) {
        return new CustomerDto(productRepository.save(product.createCustomer()).get());
    }

    @Override
    public CustomerDto updateCustomer(int productId, CustomerDto product) {
          return new CustomerDto(productRepository.update(productId, product.createCustomer()).get());
    }

    @Override
    public boolean deleteCustomer(int productId) {
       return productRepository.delete(productId);
    }
    
}
