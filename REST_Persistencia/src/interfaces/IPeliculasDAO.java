 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.Pelicula;
import java.util.List;

/**
 *
 * @author Paulina Cortez Alamilla.
 */
public interface IPeliculasDAO {
    public List<Pelicula>consultarTodos();
    public Pelicula buscarID(Long id);
    public boolean agregar (Pelicula pelicula);
    public boolean actualizar (Pelicula pelicula);
    public boolean eliminar (Long id);
    public List<Pelicula>consultarDirector(String director);
}
