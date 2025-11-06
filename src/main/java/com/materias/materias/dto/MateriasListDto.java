package com.materias.materias.dto;

import lombok.Data;

@Data
public class MateriasListDto {
    private Long id;
    private String clave;
    private String nombre;
    private String descripcion;
    private boolean activo;
}
