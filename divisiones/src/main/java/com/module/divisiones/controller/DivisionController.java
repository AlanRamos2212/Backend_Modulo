package com.module.divisiones.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.module.divisiones.dto.DivisionCreateDTO;
import com.module.divisiones.dto.DivisionResponseDTO;
import com.module.divisiones.service.DivisionService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/divisiones")
@RequiredArgsConstructor
public class DivisionController {

    private final DivisionService divisionService;

    @PostMapping
    public ResponseEntity<DivisionResponseDTO> crear(@Valid @RequestBody DivisionCreateDTO dto) {
        DivisionResponseDTO response = divisionService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
