/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.jakartaeshop.repository.impl;

import gr.codehub.jakartaeshop.model.Product;
import gr.codehub.jakartaeshop.repository.ProductRepository;
import gr.codehub.jakartaeshop.repository.impl.RepositoryImpl;
import java.util.Optional;

/**
 *
 * @author iracl
 */
public class ProductRepositoryImpl extends RepositoryImpl<Product> implements ProductRepository{

    @Override
    public Class<Product> getClassType() {
        return Product.class;
    }

    @Override
    public String getClassName() {
        return Product.class.getName();
    }

    @Override
    public void copyValues(Product tSource, Product tTarget) {
        tTarget.setName(tSource.getName());
    }

    @Override
    public Optional<Product> update(int id, Product t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
