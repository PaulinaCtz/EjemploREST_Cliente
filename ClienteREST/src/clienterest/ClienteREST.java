/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clienterest;

import entidades.Pelicula;
import entidades.Producto;
import java.util.List;
import java.util.Scanner;
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
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("1. Insertar");
            System.out.println("2. Actualizar");
            System.out.println("3. Eliminar");
            System.out.println("4. Consultar pelicula por ID");
            System.out.println("5. Consultar todo");
            System.out.println("6. Consultar pelicula por director");
            System.out.println("0. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    scanner.nextLine();
                    System.out.print("\nIngrese el nombre de la pelicula: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el director: ");
                    String director = scanner.nextLine();
                    System.out.print("Ingrese la sinopsis: ");
                    String sinopsis = scanner.nextLine();
                    Pelicula nuevaPelicula = new Pelicula(nombre, director, sinopsis);
                    boolean agregar = cliente.agregarPelicula(nuevaPelicula);
                    if (agregar) {
                        System.out.println("Pelicula insertada correctamente.");
                    } else {
                        System.out.println("La pelicula no se pudo insertar correctamente");
                    }
                    break;

                case 2:
                    System.out.print("\nIngrese el ID de la pelicula a actualizar: ");
                    Long id = scanner.nextLong();
                    Pelicula peliculaActualizar = cliente.consultarPeliculaPorID(String.valueOf(id));
                    if (peliculaActualizar != null) {
                        scanner.nextLine();
                        System.out.print("\nIngrese el nombre de la pelicula: ");
                        peliculaActualizar.setNombre(scanner.nextLine());
                        System.out.print("Ingrese el director: ");
                        peliculaActualizar.setDirector(scanner.nextLine());
                        System.out.print("Ingrese la sinopsis: ");
                        peliculaActualizar.setSinopsis(scanner.nextLine());
                        boolean actualizar = cliente.actualizarPelicula(peliculaActualizar, id.toString());
                        if (actualizar) {
                            System.out.println("Pelicula actualizada correctamente.");
                        } else {
                            System.out.println("La pelicula no se pudo actualizar correctamente.");
                        }
                    } else {
                        System.out.println("La pelicula no fue encontrada.");
                    }
                    break;

                case 3:
                    System.out.print("\nIngrese el ID de la pelicula a eliminar: ");
                    Long idE = scanner.nextLong();
                    Pelicula peliculaEliminar = cliente.consultarPeliculaPorID(String.valueOf(idE));
                    if (peliculaEliminar != null) {
                        boolean eliminar = cliente.eliminarPelicula(idE.toString());
                        if (eliminar) {
                            System.out.println("Pelicula eliminada correctamente.");
                        } else {
                            System.out.println("La pelicula no se pudo eliminar correctamente");
                        }
                    } else {
                        System.out.println("La pelicula no fue encontrada");
                    }
                    break;

                case 4:
                    System.out.print("\nIngrese el ID de la pelicula a consultar: ");
                    Long idConsultar = scanner.nextLong();
                    Pelicula peliculaConsultar = cliente.consultarPeliculaPorID(String.valueOf(idConsultar));
                    if (peliculaConsultar != null) {
                        System.out.println("Pelicula encontrada");
                        System.out.println(peliculaConsultar.toString());
                    } else {
                        System.out.println("Pelicula no encontrada");
                    }
                    break;

                case 5:
                    List<Pelicula> peliculas = cliente.consultarPeliculas();
                    System.out.println("\nPeliculas encontradas: " + peliculas.size());
                    for (Pelicula pelicula : peliculas) {
                        System.out.println(pelicula.toString());
                    }
                    break;

                case 6:
                    scanner.nextLine();
                    System.out.print("\nIngrese el director a consultar: ");
                    String directorConsultar = scanner.nextLine();
                    List<Pelicula> peliculasConsultadas = cliente.consultarPeliculaPorDirector(String.valueOf(directorConsultar));
                    if (!peliculasConsultadas.isEmpty()) {
                        for (Pelicula pelicula : peliculasConsultadas) {
                            System.out.println(pelicula.toString());
                        }
                    } else {
                        System.out.println("Peliculas no encontradas");
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
