package gr.codehub.jakartaeshop.resource;

import gr.codehub.jakartaeshop.model.Employee;
import gr.codehub.jakartaeshop.service.EmployeeService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Path("/")
public class EmployeeResource {

    @Inject
    private EmployeeService employeeService;

    @Path("/")
    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello, World!";
    }
    
     @Path("/links")
    @GET
    @Produces("text/html")
    public String links() {
        return "<a href='http://localhost:8080/jakartaeshop-1.0-SNAPSHOT/employee/1'>links</a>";
    }
    

    @Path("/employee")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Employee getEmployee(@QueryParam("id") int employeeId, @QueryParam("location") String location){
        return employeeService.readEmployee(employeeId);
    }

   


    @Path("/employee/{employeeId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Employee getEmployee(@PathParam("employeeId") int employeeId){
        return employeeService.readEmployee(employeeId);
    }

     @Path("/employee")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Employee saveEmployee(Employee employee){
        return employeeService.saveEmployee(employee.getName());
    }
    

}