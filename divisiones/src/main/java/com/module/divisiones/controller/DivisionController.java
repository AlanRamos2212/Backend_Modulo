package com.module.divisiones.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.module.divisiones.dto.DivisionCreateDTO;
import com.module.divisiones.dto.DivisionDeleteDTO;
import com.module.divisiones.dto.DivisionResponseDTO;
import com.module.divisiones.service.DivisionService;

import java.util.List;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/divisiones")
@RequiredArgsConstructor
public class DivisionController {

    private final DivisionService divisionService;

    @GetMapping
    public ResponseEntity<List<DivisionResponseDTO>> listar() {
        List<DivisionResponseDTO> response = divisionService.findAll();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DivisionResponseDTO> obtener(@PathVariable Integer id) {
        DivisionResponseDTO response = divisionService.findById(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<DivisionResponseDTO> crear(@Valid @RequestBody DivisionCreateDTO dto) {
        DivisionResponseDTO response = divisionService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DivisionResponseDTO> actualizar(@PathVariable Integer id,
            @Valid @RequestBody DivisionCreateDTO dto) {
        DivisionResponseDTO response = divisionService.update(id, dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DivisionDeleteDTO> eliminar(@PathVariable Integer id) {
        DivisionDeleteDTO response = divisionService.delete(id);
        return ResponseEntity.ok(response);
    }
}
