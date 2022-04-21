package gr.codehub.jakartaeshop.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data   
@NoArgsConstructor
@AllArgsConstructor
public class ApiResult <T>{

    T data;
    String description;
    int statusCode;
}
