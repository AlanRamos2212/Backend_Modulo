package com.module.divisiones.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.module.divisiones.entity.Division;

public interface DivisionRepository extends JpaRepository<Division, Integer> {
}