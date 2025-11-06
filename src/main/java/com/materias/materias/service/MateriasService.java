package com.materias.materias.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.materias.materias.entity.Materias;
import com.materias.materias.repository.MateriasRepository;
import com.materias.materias.dto.MateriasAddDto;
import com.materias.materias.dto.MateriasEditDto;
import com.materias.materias.dto.MateriasListDto;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MateriasService {
    @Autowired
    private MateriasRepository materiasRepository;
    // Historia de usuario Listar Materias - Adonai Lorenzo Nuñez
    public List<MateriasListDto> listarMaterias() {
        return materiasRepository.findAll()
                .stream()
                .map(materia -> {
                    MateriasListDto dto = new MateriasListDto();
                    dto.setId(materia.getId());
                    dto.setClave(materia.getClave());
                    dto.setNombre(materia.getNombre());
                    dto.setDescripcion(materia.getDescripcion());
                    dto.setActivo(materia.getActivo());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    // Historia de usuario Agregar Materias - Jonathan Molina de Jesus
    public Materias agregarMateria(MateriasAddDto materiaDto) {
        // Crear una nueva instancia de Materias
        Materias nuevaMateria = new Materias();
        nuevaMateria.setClave(materiaDto.getClave());
        nuevaMateria.setNombre(materiaDto.getNombre());
        nuevaMateria.setDescripcion(materiaDto.getDescripcion());
        nuevaMateria.setActivo(true);

        // Guardar y retornar la nueva materia
        return materiasRepository.save(nuevaMateria);
    }

    // Historia de usuario Editar Materias - Erwin Javier Martinez Morales
    public Materias editarMateria(Long id, MateriasEditDto materiaDto) {
        // Buscar la materia por ID
        Materias materia = materiasRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Materia no encontrada"));

        // Actualizar los datos de la materia
        materia.setClave(materiaDto.getClave());
        materia.setNombre(materiaDto.getNombre());
        materia.setDescripcion(materiaDto.getDescripcion());

        // Guardar cambios y retornar la materia actualizada
        return materiasRepository.save(materia);
    }

    // Historia de usuario Eliminar Materias - Juan Antonio Garcia Perez
    public boolean deleteMateria(Long id) {
        return materiasRepository.findById(id)
                .map(materia -> {
                    // Cambiar activo al valor contrario
                    materia.setActivo(!materia.getActivo());
                    materiasRepository.save(materia);
    }
}

/*
 INSERT INTO t_materias (nombre, clave, descripcion, activo) VALUES ('Matemáticas', 'MAT101', 'Álgebra y cálculo básico', 1);
INSERT INTO t_materias (nombre, clave, descripcion, activo) VALUES ('Física', 'FIS201', 'Mecánica y termodinámica', 1);
INSERT INTO t_materias (nombre, clave, descripcion, activo) VALUES ('Programación', 'PROG301', 'Fundamentos de programación en Java', 1);
INSERT INTO t_materias (nombre, clave, descripcion, activo) VALUES ('Bases de Datos', 'BD401', 'Diseño y administración de bases de datos', 1);
 */