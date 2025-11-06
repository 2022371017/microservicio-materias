package com.materias.materias.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.materias.materias.dto.MateriasEditDto;
import com.materias.materias.dto.MateriasListDto;
import com.materias.materias.entity.Materias;
import com.materias.materias.service.MateriasService;
import java.util.List;

@RestController
@RequestMapping("/api/materias")
public class MateriasController {
    @Autowired
    private MateriasService materiasService;
    
    // Historia de usuario Listar Materias - Adonai Lorenzo Nuñez
    @GetMapping("/listar-materias")
    public ResponseEntity<List<MateriasListDto>> listarMaterias() {
        List<MateriasListDto> materias = materiasService.listarMaterias();
        return ResponseEntity.ok(materias);
    }

    // Historia de usuario Editar Materias - Erwin Javier Martinez Morales
    @PutMapping("/editar-materias/{id}")
    public ResponseEntity<Materias> editarMateria(@PathVariable Long id, @RequestBody MateriasEditDto materiaDto) {
        try {
            Materias materiaActualizada = materiasService.editarMateria(id, materiaDto);
            return ResponseEntity.ok(materiaActualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
