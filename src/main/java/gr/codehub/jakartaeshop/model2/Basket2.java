/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.jakartaeshop.model2;

import gr.codehub.jakartaeshop.model.*;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
public class Basket2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
     
    //foreign key
   @ManyToOne 
    private Customer2 customer;
    
   //inverse property
   @ManyToMany(mappedBy ="baskets")
   private List<Product2> products;
     
}
