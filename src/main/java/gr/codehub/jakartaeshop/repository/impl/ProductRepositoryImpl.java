/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.jakartaeshop.repository.impl;

import gr.codehub.jakartaeshop.eshopEnum.Category;
import gr.codehub.jakartaeshop.model.BasketProduct;
import gr.codehub.jakartaeshop.model.Product;
import gr.codehub.jakartaeshop.repository.ProductRepository;
import gr.codehub.jakartaeshop.repository.impl.RepositoryImpl;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author iracl
 */
public class ProductRepositoryImpl extends RepositoryImpl<Product> implements ProductRepository {

     @PersistenceContext(unitName = "Persistence")
    private EntityManager em;
    
    
    @Override
    public Class<Product> getClassType() {
        return Product.class;
    }

    @Override
    public String getClassName() {
        return Product.class.getName();
    }

    @Override
    public void copyValues(Product tTarget, Product tSource) {
        tTarget.setName(tSource.getName());
        tTarget.setPrice(tSource.getPrice());
        tTarget.setDescription(tSource.getDescription());
        tTarget.setShelf(tSource.getShelf());
        tTarget.setCategory(tSource.getCategory());
        tTarget.setAvailable(tSource.isAvailable());
        tTarget.setInventoryQuantity(tSource.getInventoryQuantity());
    }

    @Override
    public List<Product> findByName(String productName) {
          return em.createQuery("from Product p where p.name = :productName").setParameter("productName", productName).getResultList();
    }

     
}
