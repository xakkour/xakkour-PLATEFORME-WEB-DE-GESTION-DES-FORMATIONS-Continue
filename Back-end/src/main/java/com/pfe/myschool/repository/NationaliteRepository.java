package com.pfe.myschool.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.pfe.myschool.model.Nationalite;

@Repository
public interface NationaliteRepository extends JpaRepository<Nationalite, Long>{

	@Query(value = "SELECT count(code) FROM Nationalite")
	public int nbre();

	@Query(value = "SELECT max(code) FROM Nationalite")
	public int max();

	public List<Nationalite> findAllByLibelleContaining(String libelle);

	public Optional<Nationalite> findByCode(String code);


}
