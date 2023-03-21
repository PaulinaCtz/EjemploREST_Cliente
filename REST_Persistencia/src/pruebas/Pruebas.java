/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;

import implementaciones.DAOFactory;
import interfaces.IPeliculasDAO;
import entidades.Pelicula;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Paulina Cortez Alamilla.
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        IPeliculasDAO peliculasDAO = DAOFactory.crearJugadoresDAO();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("1. Insertar");
            System.out.println("2. Actualizar");
            System.out.println("3. Eliminar");
            System.out.println("4. Consultar pelicula por ID");
            System.out.println("5. Consultar todo");
            System.out.println("0. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    Pelicula nuevaPelicula = new Pelicula();
                    scanner.nextLine();
                    System.out.print("Ingrese el nombre de la pelicula: ");
                    nuevaPelicula.setNombre(scanner.nextLine());
                    System.out.print("Ingrese el director: ");
                    nuevaPelicula.setDirector(scanner.nextLine());
                    System.out.print("Ingrese la sinopsis: ");
                    nuevaPelicula.setSinopsis(scanner.nextLine());
                    peliculasDAO.agregar(nuevaPelicula);
                    System.out.println("Pelicula insertada correctamente");
                    break;

                case 2:
                    System.out.print("Ingrese el ID de la pelicula a actualizar: ");
                    Long id = scanner.nextLong();
                    Pelicula peliculaActualizar = peliculasDAO.buscarID(id);
                    if (peliculaActualizar != null) {
                        System.out.print("Ingrese el nombre de la pelicula ");
                        peliculaActualizar.setNombre(scanner.nextLine());
                        System.out.print("Ingrese el director: ");
                        peliculaActualizar.setDirector(scanner.nextLine());
                        System.out.print("Ingrese la sinopsis: ");
                        peliculaActualizar.setSinopsis(scanner.nextLine());
                        peliculasDAO.actualizar(peliculaActualizar);
                        System.out.println("Pelicula actualizada correctamente");
                    } else {
                        System.out.println("Pelicula no encontrada");
                    }
                    break;

                case 3:
                    System.out.print("Ingrese el ID de la pelicula a eliminar: ");
                    Long idEliminar = scanner.nextLong();
                    Pelicula peliculaEliminar = peliculasDAO.buscarID(idEliminar);
                    if (peliculaEliminar != null) {
                        peliculasDAO.eliminar(idEliminar);
                        System.out.println("Pelicula eliminada correctamente");
                    } else {
                        System.out.println("Pelicula no encontrada");
                    }
                    break;

                case 4:
                    System.out.print("Ingrese el ID de la pelicula a consultar: ");
                    Long idConsultar = scanner.nextLong();
                    Pelicula peliculaConsultar = peliculasDAO.buscarID(idConsultar);
                    if (peliculaConsultar != null) {
                        System.out.println("ID: " + peliculaConsultar.getId());
                        System.out.println("Título: " + peliculaConsultar.getNombre());
                        System.out.println("Director " + peliculaConsultar.getDirector());
                        System.out.println("Sinopsis " + peliculaConsultar.getSinopsis());
                    } else {
                        System.out.println("Pelicula no encontrada");
                    }
                    break;

                case 5:
                    List<Pelicula> peliculas = peliculasDAO.consultarTodos();
                    System.out.println("Peliculas encontradas: " + peliculas.size());
                    for (Pelicula pelicula : peliculas) {
                        System.out.println("ID: " + pelicula.getId());
                        System.out.println("Título: " + pelicula.getNombre());
                        System.out.println("Director " + pelicula.getDirector());
                        System.out.println("Sinopsis " + pelicula.getSinopsis());
                    }
                    break;
                case 0:
                    System.out.println("Saliendo del programa");
                    break;

                default:
                    System.out.println("Opción inválida");
                    break;
            }
            System.out.println();
        } while (opcion != 0);

    }
}
