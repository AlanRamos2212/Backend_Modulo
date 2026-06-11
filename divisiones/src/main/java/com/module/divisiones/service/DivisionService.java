package com.module.divisiones.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.module.divisiones.dto.DivisionCreateDTO;
import com.module.divisiones.dto.DivisionDeleteDTO;
import com.module.divisiones.dto.DivisionResponseDTO;
import com.module.divisiones.entity.Division;
import com.module.divisiones.entity.EstatusDivision;
import com.module.divisiones.exception.ResourceNotFoundException;
import com.module.divisiones.repository.DivisionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DivisionService {

    private final DivisionRepository divisionRepository;

    public List<DivisionResponseDTO> findAll() {
        return divisionRepository.findAll().stream()
                .map(DivisionResponseDTO::fromEntity)
                .toList();
    }

    public DivisionResponseDTO findById(Integer id) {
        Division division = divisionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontró la división con id: " + id));
        return DivisionResponseDTO.fromEntity(division);
    }

    public DivisionResponseDTO create(DivisionCreateDTO dto) {
        Division division = new Division();
        division.setNombre(dto.getNombre());
        division.setSiglas(dto.getSiglas());
        division.setDescripcion(dto.getDescripcion());
        division.setSlug(dto.getSlug());
        division.setEstatus(EstatusDivision.valueOf(dto.getEstatus()));

        Division saved = divisionRepository.save(division);
        return DivisionResponseDTO.fromEntity(saved);
    }

    public DivisionResponseDTO update(Integer id, DivisionCreateDTO dto) {
        Division division = divisionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Division no encontrada"));

        division.setNombre(dto.getNombre());
        division.setSiglas(dto.getSiglas());
        division.setDescripcion(dto.getDescripcion());
        division.setSlug(dto.getSlug());
        division.setEstatus(EstatusDivision.valueOf(dto.getEstatus()));

        Division saved = divisionRepository.save(division);
        return DivisionResponseDTO.fromEntity(saved);
    }

    public DivisionDeleteDTO delete(Integer id) {
        if (!divisionRepository.existsById(id)) {
            throw new ResourceNotFoundException("No se encontró la división con id: " + id);
        }

        divisionRepository.deleteById(id);

        DivisionDeleteDTO response = new DivisionDeleteDTO();
        response.setId(id);
        response.setMensaje("La división con id " + id + " fue eliminada correctamente.");
        return response;
    }
}
