package com.pfe.myschool.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.pfe.myschool.model.ModReglement;

@Repository
public interface ModReglementRepository extends JpaRepository<ModReglement, Long> {

	@Query(value = "SELECT count(code) FROM ModReglement")
	public int nbre();

	@Query(value = "SELECT max(code) FROM ModReglement")
	public int max();

	public Optional<ModReglement> findByCode(String code);

	public List<ModReglement> findAllByLibelleContaining(String libelle);
	


}
