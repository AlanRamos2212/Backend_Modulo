package com.module.divisiones.service;

import org.springframework.stereotype.Service;

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
}
