package com.pfe.myschool.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.pfe.myschool.model.Specialite;

@Repository
public interface SpecialiteRepository extends JpaRepository<Specialite, Long>{

	@Query(value = "SELECT count(code) FROM Specialite")
	public int nbre();

	@Query(value = "SELECT max(code) FROM Specialite")
	public int max();

	public List<Specialite> findAllByLibelleContaining(String libelle);

	public Optional<Specialite> findById(long id );
}
