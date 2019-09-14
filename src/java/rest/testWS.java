/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import entidades.Producto;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import servicios.ProductoService;

/**
 * REST Web Service
 *
 * @author XxkokoxXT
 */
@Path("testWS")
public class testWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of testWS
     */
    public testWS() {
    }
    
    @GET
    @Path("listarProductos")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarProductos(){
        try {
            List<Producto> productos = new ProductoService().listarProductos();
            
            String json = new Gson().toJson(productos);
            
            return Response.ok(json, MediaType.APPLICATION_JSON).build();
     
        } catch (Exception e) {
            return Response.status(Response.Status.SEE_OTHER).entity("Error: " + e.toString()).build();
        }
    }

}
