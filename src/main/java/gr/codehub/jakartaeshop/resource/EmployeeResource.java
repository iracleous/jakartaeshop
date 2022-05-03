package gr.codehub.jakartaeshop.resource;

import gr.codehub.jakartaeshop.dto.EmployeeDto;
import gr.codehub.jakartaeshop.model.Employee;
import gr.codehub.jakartaeshop.service.EmployeeService;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Path("/")
 
public class EmployeeResource {

    @Inject
    private EmployeeService employeeService;

    @PermitAll
    @Path("/ping")
    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello, World!";
    }
    
    @PermitAll
    @Path("/links")
    @GET
    @Produces("text/html")
    public  String links() {
        return "<a href='http://localhost:8080/ed-app/api/employee/1'>links</a>";
    }
    
  
    
    @Path("/employee")
 @PermitAll
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public EmployeeDto getEmployee(
            @QueryParam("id") int employeeId, 
            @QueryParam("location") String location){
        return employeeService.readEmployee(employeeId);
    }

    @Path("/employee/{employeeId}")
    @PermitAll
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @RolesAllowed("ADMIN")
    public EmployeeDto getEmployee( @PathParam("employeeId") int employeeId){
        return employeeService.readEmployee(employeeId);
    }

    @Path("/employee")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @RolesAllowed("ADMIN")
    public EmployeeDto saveEmployee(Employee employee){
        return employeeService.saveEmployee(employee.getName());
    }
    

     @Path("/employee/{employeeId}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @RolesAllowed("ADMIN")
    public EmployeeDto updateEmployee(@PathParam("employeeId")int employeeId, EmployeeDto employee){
        
        return employeeService.updateEmployee( employeeId, employee);
    }
    
    
     @Path("/employee/{employeeId}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @RolesAllowed("ADMIN")
    public boolean deleteEmployee(@PathParam("employeeId")int employeeId){
        
        return employeeService.deleteEmployee( employeeId );
    }
    
}