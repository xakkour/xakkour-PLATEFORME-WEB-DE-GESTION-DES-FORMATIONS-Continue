package com.pfe.myschool.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.pfe.myschool.model.TypePaiement;

@Repository
public interface TypePaiementRepository extends JpaRepository<TypePaiement, Long> {

	Optional<TypePaiement> findByCode(String code);
	@Query(value = "SELECT count(code) FROM TypePaiement")
	public int nbre();

	@Query(value = "SELECT max(code) FROM TypePaiement")
	public int max();

	public List<TypePaiement> findAllByLibelleContaining(String libelle);
}
