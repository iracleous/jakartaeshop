/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.jakartaeshop.resource;

import gr.codehub.jakartaeshop.dto.BasketDto;
import gr.codehub.jakartaeshop.dto.BasketProductDto;
import gr.codehub.jakartaeshop.service.BasketService;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author iracl
 */
@Path("/basket")
public class BasketResource {

     @Inject
    private BasketService basketService; 
    
    @Path("/{basketId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public BasketDto getBasket(@PathParam("basketId") int basketId) {
        return basketService.getBasket(basketId);
    }

    @Path("/")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<BasketDto> getBasket(@QueryParam("customerId") int customerId,
            @QueryParam("pageCount") int pageCount, @QueryParam("pageSize") int pageSize) {
        return basketService.getBasket(customerId, pageCount, pageSize);
    }

    @Path("/")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public BasketDto createBasket() {
        return basketService.createBasket();
    }

    @Path("/{basketId}/product/{productId}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public BasketProductDto addIntoBasket(@PathParam("basketId") int basketId,
            @PathParam("productId") int productId) {
        return basketService.addIntoBasket(basketId, productId);
    }

    @Path("/{basketId}/customer/{customerId}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public BasketDto assignBasketToCustomer(@PathParam("basketId") int basketId,
            @PathParam("customerId") int customerId) {
        return basketService.assignBasketToCustomer(basketId, customerId);
    }

    @Path("/{basketId}/checkout")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public BasketDto checkoutBasket(@PathParam("basketId") int basketId) {
         return basketService.checkoutBasket(basketId);
    }

}
