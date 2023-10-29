package com.pfe.myschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.pfe.myschool.model.Jour;
public interface JourRepository extends JpaRepository<Jour, Long>{
	@Query(value = "SELECT count(code) FROM Jour")
	public int nbre() ;
	@Query(value = "SELECT max(code) FROM Jour")
	public int max();
}
