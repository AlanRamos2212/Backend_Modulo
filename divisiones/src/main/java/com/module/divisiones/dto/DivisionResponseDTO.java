package com.module.divisiones.dto;

import java.time.LocalDateTime;

import com.module.divisiones.entity.Division;

import lombok.Data;

@Data
public class DivisionResponseDTO {

    private Integer id;
    private String nombre;
    private String siglas;
    private String descripcion;
    private String slug;
    private String estatus;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static DivisionResponseDTO fromEntity(Division division) {
        DivisionResponseDTO dto = new DivisionResponseDTO();
        dto.setId(division.getId());
        dto.setNombre(division.getNombre());
        dto.setSiglas(division.getSiglas());
        dto.setDescripcion(division.getDescripcion());
        dto.setSlug(division.getSlug());
        dto.setEstatus(division.getEstatus().name());
        dto.setCreatedAt(division.getCreatedAt());
        dto.setUpdatedAt(division.getUpdatedAt());
        return dto;
    }
}
