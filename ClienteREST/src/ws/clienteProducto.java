/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/JerseyClient.java to edit this template
 */
package ws;

import entidades.Producto;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
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

    public Response putJson(Producto producto, int id) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("{0}", new Object[]{id})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(producto, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
    }

    public Response postJson(Producto producto) throws ClientErrorException {
        return webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(producto, javax.ws.rs.core.MediaType.APPLICATION_JSON), Response.class);
    }

    public Response deleteJson(int id) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("{0}", new Object[]{id})).request().delete(Response.class);
    }

    public Producto getJsonById(int id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("{0}", new Object[]{id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(Producto.class);
    }
    
    public Producto[] getJson() throws ClientErrorException {
        WebTarget resource = webTarget;
        Invocation.Builder request = resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON);
        return request.get(Producto[].class);
    }

    public void close() {
        client.close();
    }
    
}
