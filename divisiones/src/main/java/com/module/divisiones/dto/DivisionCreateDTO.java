package com.module.divisiones.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class DivisionCreateDTO {

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 150)
    private String nombre;

    @Size(max = 10)
    private String siglas;

    private String descripcion;

    @NotBlank(message = "El slug es obligatorio")
    @Size(max = 150)
    private String slug;

    private String estatus = "activo";
}
