package com.pfe.myschool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.pfe.myschool.model.Domaine;

@Repository
public interface DomaineRepository extends JpaRepository<Domaine, Long>{
	
	@Query(value = "SELECT count(code) FROM Domaine")
	public int nbre();
	@Query(value = "SELECT max(code) FROM Domaine")
	public int max();

	List<Domaine> findAllByLibelleContaining(String libelle);


}
