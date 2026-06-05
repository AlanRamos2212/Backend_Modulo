package com.module.divisiones.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.module.divisiones.dto.DivisionCreateDTO;
import com.module.divisiones.dto.DivisionResponseDTO;
import com.module.divisiones.entity.Division;
import com.module.divisiones.entity.EstatusDivision;
import com.module.divisiones.repository.DivisionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DivisionService {

    private final DivisionRepository divisionRepository;

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
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Division no encontrada"));

        division.setNombre(dto.getNombre());
        division.setSiglas(dto.getSiglas());
        division.setDescripcion(dto.getDescripcion());
        division.setSlug(dto.getSlug());
        division.setEstatus(EstatusDivision.valueOf(dto.getEstatus()));

        Division saved = divisionRepository.save(division);
        return DivisionResponseDTO.fromEntity(saved);
    }
}
