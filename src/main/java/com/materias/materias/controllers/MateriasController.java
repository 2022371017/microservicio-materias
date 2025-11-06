package com.materias.materias.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.materias.materias.dto.MateriasAddDto;
import com.materias.materias.dto.MateriasEditDto;
import com.materias.materias.dto.MateriasListDto;
import com.materias.materias.entity.Materias;
import com.materias.materias.service.MateriasService;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
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

    // Historia de usuario Agregar Materias - Jonathan Molina de Jesus
    @PostMapping("/agregar-materia")
    public ResponseEntity<Materias> agregarMateria(@RequestBody MateriasAddDto materiaDto) {
        Materias newMateria = materiasService.agregarMateria(materiaDto);
        return ResponseEntity.ok(newMateria);
    }

    // Historia de usuario Editar Materias - Erwin Javier Martinez Morales
    @PutMapping("/editar-materia/{id}")
    public ResponseEntity<Materias> editarMateria(@PathVariable Long id, @RequestBody MateriasEditDto materiaDto) {
        try {
            Materias materiaActualizada = materiasService.editarMateria(id, materiaDto);
            return ResponseEntity.ok(materiaActualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
  
    // Historia de usuario Eliminar Materia - Juan Antonio Garcia Perez
    @DeleteMapping("/eliminar-materia/{id}")
    public boolean deleteMateria(@PathVariable Long id) {
        return materiasService.deleteMateria(id);
      }
}
