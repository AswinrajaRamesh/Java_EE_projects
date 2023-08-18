/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trg.Service;

import com.trg.Dao.EmployeeDao;
import com.trg.entity.Employee;
import java.util.Collection;
import javax.inject.Inject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.DELETE;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;


@Path("employees")
public class EmployeeResource {

    //@Inject
    EmployeeDao dao = new EmployeeDao();
    
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Employee getEmployee(@PathParam("id") int eid){
        return dao.getEmployee(eid);
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Collection<Employee> getAllEmployees(){
        return dao.getAll();
    }
    
    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    public String update(Employee e){
        if(dao.updateEmployee(e)){
            return "updated";
        }
        else
            return "not deleted";
    }
    
    @DELETE
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String delete(@PathParam("id") int eid){
        if(dao.deleteEmployee(eid)){
            return "deleted";
        }
        else
            return "not deleted";
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String save(Employee e){
        if(dao.saveEmployee(e)){
        return "successfully saved employee";
        }
        else
        {
            return "employee with id "+e.getEmpId()+" exists...";
        }
        
    }
    
}
