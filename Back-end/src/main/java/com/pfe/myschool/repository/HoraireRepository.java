package com.pfe.myschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pfe.myschool.model.Horaire;

public interface HoraireRepository extends JpaRepository<Horaire, Long>{
	@Query(value = "SELECT count(code) FROM Horaire")
	public int nbre();
	@Query(value = "SELECT max(code) FROM Horaire")
	public int max();
}
