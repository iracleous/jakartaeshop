package gr.codehub.jakartaeshop.dto;

  
import java.sql.Date;
import lombok.Data;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import gr.codehub.jakartaeshop.model.Basket;

 

/**
 *
 * Expected json
 * { "productIds": [1,2,2]}
 */

@Data   
@NoArgsConstructor
@AllArgsConstructor
public class BasketDto {
    private int id;
    private Date date;

    private String customerName;
    private Long customerId;

    private List<Long> productIds;
    private List<ProductDto> products;
  
    
    public BasketDto(Basket basket){
      id = basket.getId();
      date = basket.getDate();
     // customerName = basket.getCustomer().getName();
               
    }

    public Basket createBasket(){
        Basket basket = new Basket();
        basket.setId(id);
        basket.setDate(date);

        return basket;
    }
    
    
    
 }


