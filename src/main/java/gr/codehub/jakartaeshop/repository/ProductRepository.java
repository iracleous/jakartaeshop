/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.jakartaeshop.repository;

import gr.codehub.jakartaeshop.model.Product;
import java.util.List;

/**
 *
 * @author iracl
 */
public interface ProductRepository extends Repository<Product>{
    List<Product> findByName(String productName);
}
