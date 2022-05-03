/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.jakartaeshop.service;

import gr.codehub.jakartaeshop.dto.ProductDto;
import gr.codehub.jakartaeshop.model.Product;
import gr.codehub.jakartaeshop.repository.EmployeeRepository;
import gr.codehub.jakartaeshop.repository.ProductRepository;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;

/**
 *
 * @author iracl
 */
public class ProductServiceImpl  implements ProductService{

     @Inject
    private ProductRepository productRepository;
    
    @Override
    public List<ProductDto> readProduct(String productName, String description) {
        if (productName==null)
             return productRepository.findAll()
                 .stream().map(ProductDto::new).toList();
            
         return productRepository.findByName(productName)
                 .stream().map(ProductDto::new).toList();
    }

    @Override
    public ProductDto readProduct(int productId) {
        
        Optional<Product> product = productRepository.findById(productId);
        
        if (product.isEmpty()) return null;
        return new ProductDto(product.get());
    }

    @Override
    public ProductDto saveProduct(ProductDto product) {
        return new ProductDto(productRepository.save(product.createProduct()).get());
    }

    @Override
    public ProductDto updateProduct(int productId, ProductDto product) {
          return new ProductDto(productRepository.update(productId, product.createProduct()).get());
    }

    @Override
    public boolean deleteProduct(int productId) {
       return productRepository.delete(productId);
    }
    
}
