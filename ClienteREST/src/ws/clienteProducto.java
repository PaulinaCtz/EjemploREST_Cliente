/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/JerseyClient.java to edit this template
 */
package ws;

import entidades.Pelicula;
import java.util.Arrays;
import java.util.List;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 * Jersey REST client generated for REST resource:ProductoResource
 * [producto]<br>
 * USAGE:
 * <pre>
 *        clienteProducto client = new clienteProducto();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Paulina Cortez Alamilla.
 */
public class clienteProducto {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/EjemploREST/webresources";

    public clienteProducto() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("producto");
    }

    public boolean agregarPelicula(Pelicula pelicula) throws ClientErrorException {
        WebTarget resource = webTarget;
        Pelicula peliculaAgregada = null;
        try {
            peliculaAgregada = resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).
                    post(javax.ws.rs.client.Entity.entity(pelicula,
                            javax.ws.rs.core.MediaType.APPLICATION_JSON),
                            Pelicula.class);

            return peliculaAgregada != null;
        } catch (Exception e) {
            System.out.println("Error; " + e.getMessage());
            return false;
        }

    }

    public boolean actualizarPelicula(Pelicula pelicula, String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        Pelicula peliculaAct = null;
        try {
            resource = resource.path(java.text.MessageFormat.format("{0}",
                    new Object[]{id}));
            peliculaAct = resource.request(
                    javax.ws.rs.core.MediaType.APPLICATION_JSON).
                    put(javax.ws.rs.client.Entity.entity(pelicula,
                            javax.ws.rs.core.MediaType.APPLICATION_JSON),
                            Pelicula.class);
            return true;
        } catch (Exception e) {
            System.out.println("Error; " + e.getMessage());
            return false;
        }

    }

    public boolean eliminarPelicula(String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        Pelicula peliculaElim = null;
        try {
            resource = resource.path(java.text.MessageFormat.format("{0}",
                    new Object[]{id}));
            peliculaElim = resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).
                    delete(Pelicula.class);
            return true;
        } catch (Exception e) {
            System.out.println("Error; " + e.getMessage());
            return false;
        }
    }

    public Pelicula consultarPeliculaPorID(String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        Pelicula pelicula = null;
        try {
            resource = resource.path(java.text.MessageFormat.format("{0}",
                    new Object[]{id}));
            pelicula = resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).
                    get(Pelicula.class);
            return pelicula;
        } catch (Exception e) {
            System.out.println("Error; " + e.getMessage());
            return null;
        }
    }

    public List<Pelicula> consultarPeliculaPorDirector(String director) throws ClientErrorException {
        WebTarget webTarget = client.target("http://localhost:8080/EjemploREST/webresources");
        WebTarget resource = webTarget.path("producto/query").queryParam("director", director);
        List<Pelicula> peliculas = resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Pelicula>>() {
                });

        return peliculas;

    }
    
    public List<Pelicula> consultarPeliculas() throws ClientErrorException {
        WebTarget resource = webTarget;
        List<Pelicula> listPelis = null;
        try {
            Pelicula[] pelis = resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).
                    get(Pelicula[].class);
            listPelis = Arrays.asList(pelis);
            return listPelis;
        } catch (Exception e) {
            System.out.println("Error; " + e.getMessage());
            return null;
        }
    }

    public void close() {
        client.close();
    }

}
