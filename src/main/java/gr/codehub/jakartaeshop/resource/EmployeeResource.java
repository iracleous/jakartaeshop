package gr.codehub.jakartaeshop.resource;

import gr.codehub.jakartaeshop.model.Employee;
import gr.codehub.jakartaeshop.service.EmployeeService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/api")
public class EmployeeResource {

    @Inject
    private EmployeeService employeeService;

    @Path("/ping")
    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello, World!";
    }


    @Path("/employee")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Employee getEmployee(@QueryParam("id") int employeeId, @QueryParam("location") String location){
        return employeeService.readEmployee(employeeId);
    }

    @Path("/employee")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Employee saveEmployee(Employee employee){
        return employeeService.saveEmployee(employee.getName());
    }


    @Path("/employee/{employeeId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Employee getEmployee(@PathParam("employeeId") int employeeId){
        return employeeService.readEmployee(employeeId);
    }


}