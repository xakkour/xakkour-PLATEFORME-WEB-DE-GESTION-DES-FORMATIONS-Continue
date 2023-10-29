package com.pfe.myschool.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pfe.myschool.model.Absence;

public interface AbsenceRepository extends JpaRepository<Absence, Long>{
	@Query(value = "SELECT count(numero) FROM Absence where annee = :ann")
	public int nbre(@Param("ann") int ann);
	@Query(value = "SELECT max(numero) FROM Absence  where annee = :ann")
	public int max(@Param("ann") int ann);
}
