/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.jakartaeshop.service;

import gr.codehub.jakartaeshop.dto.BasketDto;
import gr.codehub.jakartaeshop.dto.BasketProductDto;
import gr.codehub.jakartaeshop.model.Basket;
import gr.codehub.jakartaeshop.repository.BasketRepository;
import gr.codehub.jakartaeshop.repository.CustomerRepository;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;

/**
 *
 * @author iracl
 */
public class BasketServiceImpl implements BasketService{

     @Inject
    private BasketRepository basketRepository;
     
    @Override
    public BasketDto getBasket(int basketId) {
        return new BasketDto(basketRepository.findById(basketId).get());
      }

    @Override
    public List<BasketDto> getBasket(int customerId, int pageCount, int pageSize) {
       return   basketRepository.findAll().stream()
               .map(BasketDto::new).collect(Collectors.toList());
    }

    @Override
    public BasketDto createBasket() {
        Basket basket = new Basket();
        basket.setDate(  Date.valueOf(LocalDate.now()));
        return new BasketDto(basketRepository.save(basket).get());

    }

    @Override
    public BasketProductDto addIntoBasket(int basketId, int productId) {
        return  new BasketProductDto(basketRepository.addProduct(basketId, productId).get()) ;
    }
    
    @Override
    public BasketDto removeFromBasket(int basketId, int productId) {
        return new BasketDto(basketRepository.removeProduct(basketId, productId).get());
    }

    @Override
    public BasketDto assignBasketToCustomer(int basketId, int customerId) {
         return new BasketDto(basketRepository.assignBasketToCustomer(basketId, customerId).get());
    }


    @Override
    public BasketDto checkoutBasket(int basketId) {
       return new BasketDto(basketRepository.checkoutBasket(basketId ).get());
  }
    
}
