/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package ws;

import entidades.Pelicula;
import entidades.Producto;
import implementaciones.DAOFactory;
import implementaciones.PeliculasDAO;
import interfaces.IPeliculasDAO;
import java.util.Arrays;
import java.util.List;
//import javax.ws.rs.core.Context;
//import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Paulina Cortez Alamilla.
 */
@Path("producto")
public class ProductoResource {

//    @Context
//    private UriInfo context;

    private Pelicula[] productos;
    IPeliculasDAO peliculasDAO = DAOFactory.crearJugadoresDAO();
    
    
    public ProductoResource() {
         
        
    }

    /**
     * Retrieves representation of an instance of ws.ProductoResource
     * @return an instance of entidades.ProductoResource
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson() {
        List<Pelicula> listaPeliculas = peliculasDAO.consultarTodos();
        productos=listaPeliculas.toArray(new Pelicula[listaPeliculas.size()]);
        return Response.status(Response.Status.OK).entity(productos).build();      
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJsonById(@PathParam("id") Long id) {
        // Buscamos el producto con el id especificado
        Pelicula peliculaEncontrada = null;
        
        peliculaEncontrada = peliculasDAO.buscarID(id);
        // Si no se encuentra el producto, se devuelve una respuesta con código 404 Not Found
        if (peliculaEncontrada == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        // Si se encuentra el producto, se devuelve una respuesta con código 200 OK y el producto en formato JSON
        return Response.status(Response.Status.OK).entity(peliculaEncontrada).build();
    }
    @GET
    @Path("/query")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJsonByDirector(@QueryParam("director") String director){
        List<Pelicula> listaPeliculas = peliculasDAO.consultarDirector(director);
        if(listaPeliculas.isEmpty()){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        
        productos=listaPeliculas.toArray(new Pelicula[listaPeliculas.size()]);
        return Response.status(Response.Status.OK).entity(productos).build();  
    }

    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postJson(Pelicula pelicula) {
        if(peliculasDAO.agregar(pelicula)){
            return Response.status(Response.Status.CREATED).entity(pelicula).build();
        }
        return Response.status(500).entity(pelicula).build();
    }

    /**
     * PUT method for updating or creating an instance of ProductoResource
     * @param id
     * @param pelicula
     * @return 
     */
    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response putJson(@PathParam("id") int id, Pelicula pelicula) {
        if(peliculasDAO.actualizar(pelicula)){
            return Response.status(Response.Status.OK).build();
        }
        return Response.status(500).entity(pelicula).build();
    }
    
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteJson(@PathParam("id") Long id) {
        if(peliculasDAO.eliminar(id)){
            return Response.status(Response.Status.OK).build();
        }
        return Response.status(Response.Status.NOT_FOUND).entity("No se ha encontrado el recurso a eliminar.").build();
    }
}
