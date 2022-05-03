/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.jakartaeshop.repository.impl;

import gr.codehub.jakartaeshop.model.Basket;
import gr.codehub.jakartaeshop.model.BasketProduct;
import gr.codehub.jakartaeshop.model.Customer;
import gr.codehub.jakartaeshop.model.Product;
import gr.codehub.jakartaeshop.repository.BasketRepository;
import java.util.Optional;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

/**
 *
 * @author iracl
 */
public class BasketRepositoryImpl extends RepositoryImpl<Basket> implements BasketRepository {

    @PersistenceContext(unitName = "Persistence")
    private EntityManager em;
    @Resource
    private UserTransaction userTransaction;

    @Override
    public Class<Basket> getClassType() {
        return Basket.class;
    }

    @Override
    public String getClassName() {
        return Basket.class.getName();
    }

    @Override
    public void copyValues(Basket tSource, Basket tTarget) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Optional<Basket> update(int id, Basket t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Optional<BasketProduct> addProduct(int basketId, int productId) {

        try {
            userTransaction.begin();
            Basket basket = em.find(Basket.class, basketId);
            if (basket == null) {
                userTransaction.commit();
                return Optional.empty();
            }
            Product product = em.find(Product.class, productId);
            if (product == null) {
                userTransaction.commit();
                return Optional.empty();
            }

            BasketProduct basketProduct = new BasketProduct();

            basketProduct.setQuantity(1);
            basketProduct.setProduct(product);
            basketProduct.setBasket(basket);
            em.persist(basketProduct);
            userTransaction.commit();
            return Optional.of(basketProduct);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }

    }

    @Override
    public Optional<Basket> removeProduct(int basketId, int productId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Optional<Basket> assignBasketToCustomer(int basketId, int customerId) {

        try {
            userTransaction.begin();
            Basket basket = em.find(Basket.class, basketId);
            if (basket == null) {
                userTransaction.commit();
                return Optional.empty();
            }
            Customer customer = em.find(Customer.class, customerId);
            if (customer == null) {
                userTransaction.commit();
                return Optional.empty();
            }

            basket.setCustomer(customer);
            em.persist(basket);
            userTransaction.commit();
            return Optional.of(basket);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }

    }

    @Override
    public Optional<Basket> checkoutBasket(int basketId) {
        try {
            userTransaction.begin();
            Basket basket = em.find(Basket.class, basketId);
            if (basket == null) {
                userTransaction.commit();
                return Optional.empty();
            }

            basket.setFinalized(true);
            em.persist(basket);
            userTransaction.commit();
            return Optional.of(basket);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }

    }

}
