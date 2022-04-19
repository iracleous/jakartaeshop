/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.jakartaeshop.model2;

import gr.codehub.jakartaeshop.model.*;
import gr.codehub.jakartaeshop.eshopEnum.Category;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author iracl
 */
@Data   
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double price;
    private String description;
    private String name;
    private String shelf;
    private Category category;
    private boolean available;
    private int inventoryQuantity;
    
    //inverse property
    @ManyToMany 
    private List<Basket2> baskets;
    
}
