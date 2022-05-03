/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.jakartaeshop.dto;

import gr.codehub.jakartaeshop.eshopEnum.Category;
import gr.codehub.jakartaeshop.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author iracl
 */
@Data   
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private int id;
    private double price;
    private String description;
    private String name;
    private String shelf;
    private Category category;
    private boolean available;
    
    
      public ProductDto(Product product){
        id = product.getId();
        name = product.getName();
        price = product.getPrice();
        description = product.getDescription();
         shelf = product.getShelf();
        category = product.getCategory();
        available= product.isAvailable();
         
    }

    public Product createProduct(){
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setPrice(price);
        
         product.setDescription(description);
           product.setShelf(shelf);
          product.setCategory(category);
         product.setAvailable(available);
        
         return product;
    }

    
    
    
}
