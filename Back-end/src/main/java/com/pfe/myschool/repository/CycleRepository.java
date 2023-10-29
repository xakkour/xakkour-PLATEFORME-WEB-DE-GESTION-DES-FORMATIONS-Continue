package com.pfe.myschool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.pfe.myschool.model.Cycle;

@Repository
public interface CycleRepository extends JpaRepository<Cycle, Long>{

	@Query(value = "SELECT count(code) FROM Cycle")
	public int nbre();
	@Query(value = "SELECT max(code) FROM Cycle")
	public int max();

	List<Cycle> findAllByLibelleContaining(String libelle);

	


}
