/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.jakartaeshop.dto;

import java.sql.Date;
import java.util.List;
import lombok.Data;

/**
 *
 * @author iracl
 */
@Data   
public class CustomerDtoWithBasket {
    private String customerName;
    List<Date> baskets;
}