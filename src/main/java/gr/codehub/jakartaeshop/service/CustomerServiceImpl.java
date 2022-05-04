/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.jakartaeshop.service;

import gr.codehub.jakartaeshop.dto.CustomerDto;
import gr.codehub.jakartaeshop.dto.CustomerDtoWithBasket;
import gr.codehub.jakartaeshop.model.Basket;
import gr.codehub.jakartaeshop.model.Customer;
import gr.codehub.jakartaeshop.repository.CustomerRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;

/**
 *
 * @author iracl
 */
public class CustomerServiceImpl implements CustomerService{

     @Inject
    private CustomerRepository customerRepository;
    
    @Override
    public List<CustomerDto> readCustomer(String productName, String description) {
         
             return customerRepository.findAll()
                 .stream().map(CustomerDto::new).toList();
            
        
    }

    @Override
    public CustomerDto readCustomer(int productId) {
        
        Optional<Customer> product = customerRepository.findById(productId);
        
        if (product.isEmpty()) return null;
        return new CustomerDto(product.get());
    }

    @Override
    public CustomerDto saveCustomer(CustomerDto product) {
        return new CustomerDto(customerRepository.save(product.createCustomer()).get());
    }

    @Override
    public CustomerDto updateCustomer(int productId, CustomerDto product) {
          return new CustomerDto(customerRepository.update(productId, product.createCustomer()).get());
    }

    @Override
    public boolean deleteCustomer(int customerId) {
       return customerRepository.delete(customerId);
    }

    @Override
    public CustomerDtoWithBasket readCustomerWithBasket(int customerId) {
        
        Customer customer = customerRepository.findById(customerId).get();
        
        
     List<Basket> baskets =  customerRepository.findCustomerWithBaskets(customerId);
     CustomerDtoWithBasket custBasket = new CustomerDtoWithBasket();
     custBasket.setCustomerName(customer.getName());
     custBasket.setBaskets( new ArrayList());
     baskets.forEach(basket -> custBasket.getBaskets().add(basket.getDate()));
     return custBasket;
    }
    
}
