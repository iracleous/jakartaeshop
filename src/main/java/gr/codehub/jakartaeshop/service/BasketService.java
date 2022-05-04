/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.jakartaeshop.service;

import gr.codehub.jakartaeshop.dto.BasketDto;
import gr.codehub.jakartaeshop.dto.BasketProductDto;
import gr.codehub.jakartaeshop.dto.CustomerDtoWithBasket;
import gr.codehub.jakartaeshop.model.BasketProduct;
import java.util.List;

/**
 *
 * @author iracl
 */
public interface BasketService {

    public BasketDto getBasket(int basketId);

    public List<BasketDto> getBasket(int customerId, int pageCount, int pageSize);

    public BasketDto createBasket();

    public BasketProductDto addIntoBasket(int basketId, int productId);
    public BasketDto removeFromBasket(int basketId, int productId); 

    public BasketDto assignBasketToCustomer(int basketId, int customerId);

    public BasketDto checkoutBasket(int basketId);
    
    
}
