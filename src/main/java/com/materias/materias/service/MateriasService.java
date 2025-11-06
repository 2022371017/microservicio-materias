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

    public List<MateriasListDto> listarMaterias() {
        List<Materias> materias = materiasRepository.findAll();
        return materias.stream()
            .map(materia -> {
                MateriasListDto dto = new MateriasListDto();
                dto.setClave(materia.getClave());
                dto.setNombre(materia.getNombre());
                dto.setDescripcion(materia.getDescripcion());
                dto.setActivo(materia.getActivo());
                return dto;
            })
            .collect(Collectors.toList());
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

}
