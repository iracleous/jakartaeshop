/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.jakartaeshop.repository.impl;

import gr.codehub.jakartaeshop.model.Basket;
import gr.codehub.jakartaeshop.model.BasketProduct;
import gr.codehub.jakartaeshop.repository.BasketRepository;
import java.util.Optional;

/**
 *
 * @author iracl
 */
public class BasketRepositoryImpl extends RepositoryImpl<Basket> implements BasketRepository{

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
    
}
