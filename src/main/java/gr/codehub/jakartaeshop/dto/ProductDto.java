/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.jakartaeshop.dto;

import gr.codehub.jakartaeshop.eshopEnum.Category;
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
public class ProductDto {
    private int id;
    private double price;
    private String description;
    private String name;
    private String shelf;
    private Category category;
    private boolean available;
    
}
