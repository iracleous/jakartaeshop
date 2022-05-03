/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.jakartaeshop.resource;

/**
 *
 * @author iracl
 */

import gr.codehub.jakartaeshop.dto.CustomerDto;
import gr.codehub.jakartaeshop.service.CustomerService;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/customer")
public class CustomerResource {
     @Inject
    private CustomerService productService; 
    
    
    
    @Path("/")
    @PermitAll
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CustomerDto> getCustomer(@QueryParam("name") String productName, @QueryParam("description") @DefaultValue("car") String description){
        return productService.readCustomer( productName, description);
    }

    @Path("/{productId}")
    @PermitAll
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public CustomerDto getCustomer( @PathParam("productId") int productId){
         return productService.readCustomer(productId);
    }

    @Path("/")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @RolesAllowed("ADMIN")
    public CustomerDto saveCustomer(CustomerDto product){
        return productService.saveCustomer(product);
    }
    

    @Path("/{productId}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @RolesAllowed("ADMIN")
    public CustomerDto updateCustomer(@PathParam("productId")int productId, CustomerDto product){
        
        return productService.updateCustomer( productId, product);
    }
    
    
    @Path("/{productId}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @RolesAllowed("ADMIN")
    public boolean deleteCustomer(@PathParam("productId")int productId){
          return productService.deleteCustomer( productId );
    }
}
