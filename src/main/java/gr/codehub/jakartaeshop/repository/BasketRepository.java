/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.jakartaeshop.repository;

import gr.codehub.jakartaeshop.model.Basket;
import gr.codehub.jakartaeshop.model.BasketProduct;

import java.util.Optional;

/**
 *
 * @author iracl
 */
public interface BasketRepository extends Repository<Basket>{
    Optional<BasketProduct> addProduct(int basketId, int productId);

    Optional<Basket> removeProduct(int basketId, int productId);

    Optional<Basket> assignBasketToCustomer(int basketId, int customerId);

    Optional<Basket> checkoutBasket(int basketId);
}
