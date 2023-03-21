/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.util.Objects;

/**
 *
 * @author jvale
 */
public class PeliculaDTO {
    
    Long id;
    String nombre;
    String director;
    String sinopsis;

    public PeliculaDTO(Long id, String nombre, String director, String sinopsis) {
        this.id = id;
        this.nombre = nombre;
        this.director = director;
        this.sinopsis = sinopsis;
    }

    public PeliculaDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.nombre);
        hash = 89 * hash + Objects.hashCode(this.director);
        hash = 89 * hash + Objects.hashCode(this.sinopsis);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PeliculaDTO other = (PeliculaDTO) obj;
        return Objects.equals(this.id, other.id);
    }
    
    

    @Override
    public String toString() {
        return "PeliculaDTO{" + "id=" + id + ", nombre=" + nombre + ", director=" + director + ", sinopsis=" + sinopsis + '}';
    }
    
    
}
