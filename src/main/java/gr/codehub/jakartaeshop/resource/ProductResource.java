/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.jakartaeshop.resource;

import gr.codehub.jakartaeshop.dto.EmployeeDto;
import gr.codehub.jakartaeshop.dto.ProductDto;
import gr.codehub.jakartaeshop.model.Employee;
import gr.codehub.jakartaeshop.service.EmployeeService;
import gr.codehub.jakartaeshop.service.ProductService;
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

/**
 *
 * @author iracl
 */

@Path("/Product")
public class ProductResource {
    @Inject
    private ProductService productService; 
    
    
    
    @Path("/")
    @PermitAll
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProductDto> getProduct(@QueryParam("name") String productName, @QueryParam("description") @DefaultValue("car") String description){
        return productService.readProduct( productName, description);
    }

    @Path("/{productId}")
    @PermitAll
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ProductDto getProduct( @PathParam("productId") int productId){
         return productService.readProduct(productId);
    }

    @Path("/")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @RolesAllowed("ADMIN")
    public ProductDto saveProduct(ProductDto product){
        return productService.saveProduct(product);
    }
    

    @Path("/{productId}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @RolesAllowed("ADMIN")
    public ProductDto updateProduct(@PathParam("productId")int productId, ProductDto product){
        
        return productService.updateProduct( productId, product);
    }
    
    
    @Path("/{productId}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @RolesAllowed("ADMIN")
    public boolean deleteProduct(@PathParam("productId")int productId){
          return productService.deleteProduct( productId );
    }
    
   
    
}
