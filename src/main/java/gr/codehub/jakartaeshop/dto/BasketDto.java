package gr.codehub.jakartaeshop.dto;


 
import lombok.Data;

import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 *
 * Expected json
 * { "productIds": [1,2,2]}
 */

@Data   
@NoArgsConstructor
@AllArgsConstructor
public class BasketDto {
    private Long id;
    private LocalDate date;

    private String customerName;
    private Long customerId;

    private List<Long> productIds;
    private List<ProductDto> products;
 }


