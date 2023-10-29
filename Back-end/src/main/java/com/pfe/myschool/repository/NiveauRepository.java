package com.pfe.myschool.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pfe.myschool.model.Niveau;
@Repository
public interface NiveauRepository extends JpaRepository<Niveau, Long>{


	@Query(value = "SELECT count(code) FROM Niveau")
	public int nbre();

	@Query(value = "SELECT max(code) FROM Niveau")
	public int max();

	public List<Niveau> findAllByLibelleContaining(String libelle);

	public Optional<Niveau> findByCode(String code);

}
