/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import entidades.Pelicula;
import interfaces.IConexionBD;
import interfaces.IPeliculasDAO;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Paulina Cortez Alamilla.
 */
public class PeliculasDAO implements IPeliculasDAO {
    
    private IConexionBD conexion;
    
    PeliculasDAO (IConexionBD conexionBD){
        this.conexion = conexionBD;
    }

    @Override
    public List<Pelicula> consultarTodos() {
        try {
            EntityManager em = this.conexion.crearConexion();
            return em.createQuery("SELECT p FROM Pelicula p", Pelicula.class).getResultList();
        } catch (IllegalStateException ex) {
            System.err.println("No se pudo consultar todas las películas");
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public Pelicula buscarID(Long id) {
        try {
            EntityManager em = this.conexion.crearConexion();
            return em.find(Pelicula.class, id);
        } catch (IllegalStateException ex) {
            System.err.println("No se pudo buscar la pelicula con el id: " + id);
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean agregar(Pelicula pelicula) {
        try{
            EntityManager em = this.conexion.crearConexion();
            em.getTransaction().begin();
            em.persist(pelicula);
            em.getTransaction().commit();
            return true; 
        } catch (IllegalStateException ex){
            System.err.println("No se pudo agregar la pelicula");
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean actualizar(Pelicula pelicula) {
        try{
            EntityManager em = this.conexion.crearConexion();
            em.getTransaction().begin();
            em.merge(pelicula);
            em.getTransaction().commit();
            return true; 
        } catch (IllegalStateException ex){
            System.err.println("No se pudo actualizar la pelicula");
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean eliminar(Long id) {
        try {
            EntityManager em = this.conexion.crearConexion();
            em.getTransaction().begin();
            Pelicula pelicula = em.find(Pelicula.class, id);
            em.remove(pelicula);
            em.getTransaction().commit();
            return true;
        }catch (IllegalStateException ex){
            System.err.println("No se pudo eliminar la pelicula");
            ex.printStackTrace();
            return false;
        }
    }
}
