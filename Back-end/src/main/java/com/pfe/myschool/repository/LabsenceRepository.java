package com.pfe.myschool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pfe.myschool.model.Labsence;

public interface LabsenceRepository extends JpaRepository<Labsence, Long>{
	List<Labsence> findByNumero(int numero);
}
