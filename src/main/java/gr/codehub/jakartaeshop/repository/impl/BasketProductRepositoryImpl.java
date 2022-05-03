/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.jakartaeshop.repository.impl;

import gr.codehub.jakartaeshop.model.BasketProduct;
import gr.codehub.jakartaeshop.repository.BasketProductRepository;
import java.util.Optional;

/**
 *
 * @author iracl
 */
public class BasketProductRepositoryImpl extends RepositoryImpl<BasketProduct> implements BasketProductRepository{

    @Override
    public Class<BasketProduct> getClassType() {
        return BasketProduct.class;
    }

    @Override
    public String getClassName() {
         return BasketProduct.class.getName();
    }

    @Override
    public void copyValues(BasketProduct tSource, BasketProduct tTarget) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Optional<BasketProduct> update(int id, BasketProduct t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
