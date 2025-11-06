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

    //historia de usuario eliminar- Juan Antonio Garcia Perez
       public boolean deleteMateria(Long id) {
        return materiaRepository.findById(id)
                .map(materia -> {
                    materia.setStatus("INACTIVO");
                    materiaRepository.save(materia);
                    return true;
                })
                .orElse(false);
    }
}
