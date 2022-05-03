/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.jakartaeshop.service;

import gr.codehub.jakartaeshop.dto.ProductDto;
import java.util.List;

/**
 *
 * @author iracl
 */
public interface ProductService {
    List<ProductDto> readProduct(String productName, String description);
    ProductDto readProduct(int productId);
    ProductDto saveProduct(ProductDto product);
    ProductDto updateProduct(int productId, ProductDto product);
    boolean deleteProduct( int productId );
}
