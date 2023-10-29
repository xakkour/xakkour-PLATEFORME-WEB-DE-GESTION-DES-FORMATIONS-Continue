package com.pfe.myschool.repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pfe.myschool.dto.ListTarif;
import com.pfe.myschool.model.Tarif;

@Repository
public interface TarifRepository extends JpaRepository<Tarif, Long> {

	@Query(value = "SELECT count(code) FROM Tarif")
	public int nbre();

	@Query(value = "SELECT max(code) FROM Tarif")
	public int max();

	public Optional<Tarif> findByAnnee(int annee);

	@Query(value = "SELECT new com.pfe.myschool.dto.ListTarif (a.id,a.code,a.codeSpecialite,b.libelle,a.codeDomaine,c.libelle,a.annee,a.m1,a.m2,a.m3,a.frais,a.montant,a.d1,a.d2,a.d3,a.d4)"
			+ " from Tarif a, Specialite b, Domaine c   where a.codeSpecialite = b.code and a.codeDomaine  = c.code")
	List<ListTarif> listTarif();

}
