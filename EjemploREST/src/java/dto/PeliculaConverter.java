/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import entidades.Pelicula;

/**
 *
 * @author jvale
 */
public class PeliculaConverter extends AbstractConverter<Pelicula, PeliculaDTO>{

    @Override
    public Pelicula fromDto(PeliculaDTO dto) {
        Pelicula pelicula = new Pelicula(dto.getNombre(),dto.getDirector(),dto.getSinopsis());
        return pelicula;
    }

    @Override
    public PeliculaDTO fromEntity(Pelicula entity) {
        PeliculaDTO dto = new PeliculaDTO(entity.getId(), entity.getNombre(), entity.getDirector(), entity.getSinopsis());
        return dto;
    }
    
}
