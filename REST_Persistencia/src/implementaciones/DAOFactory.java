/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import interfaces.IConexionBD;

/**
 *
 * @author Paulina Cortez Alamilla.
 */
public class DAOFactory {
    
    private static final IConexionBD conexion = new ConexionBD();
    
    public static PeliculasDAO crearJugadoresDAO(){
        return new PeliculasDAO (conexion);
    }
    
}
