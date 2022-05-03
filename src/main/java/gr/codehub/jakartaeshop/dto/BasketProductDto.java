/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.jakartaeshop.dto;

import gr.codehub.jakartaeshop.model.Basket;
import gr.codehub.jakartaeshop.model.BasketProduct;
import gr.codehub.jakartaeshop.model.Customer;

/**
 *
 * @author iracl
 */
public class BasketProductDto {
    private int id;
    public BasketProductDto(BasketProduct basket){
      id = basket.getId();
              
    }
    
     public BasketProduct createBasketProduct(){
         BasketProduct basketProduct = new BasketProduct();
         basketProduct.setId(id);
         return basketProduct;
     }
    
}
