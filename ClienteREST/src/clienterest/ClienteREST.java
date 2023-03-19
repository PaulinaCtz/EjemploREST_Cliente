/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clienterest;

import entidades.Producto;
import ws.clienteProducto;

/**
 *
 * @author Paulina Cortez Alamilla.
 */
public class ClienteREST {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        clienteProducto cliente = new clienteProducto(); 
        
        // getJson colección. 
        Producto[]productos = cliente.getJson();
        for (int i=0; i<productos.length; i++){
        System.out.println("Cache el producto: " + productos[i].getNombre());
        }
        
        System.out.print("\n");
        
        // getJsonById
        Producto productoID = cliente.getJsonById(1);
        System.out.println("Cache el producto: " + productoID.getNombre());
        
        System.out.print("\n");
        
        // postJson
        System.out.println(cliente.postJson(new Producto(5, "producto5")));
        System.out.print("\n");
        
        // putJson
        System.out.println(cliente.putJson(new Producto (3, "nombreNuevo"), 3));
        System.out.print("\n");
        
        // deleteJson
        System.out.println(cliente.deleteJson(3));
        System.out.print("\n");
        
        
    }
    
}
