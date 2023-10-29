package com.pfe.myschool.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pfe.myschool.dto.ListReglement;
import com.pfe.myschool.model.Reglement;

@Repository
public interface ReglementRepository extends JpaRepository<Reglement, Long>{

	@Query(value = "SELECT new com.pfe.myschool.dto.ListReglement (a.id,a.annee,a.numero,a.dateReglement,a.matricule,a.montant,b.nom,b.prenom,c.libelle)"
			+ " from Reglement a, Etudiant b, Classe c   where a.matricule = b.matricule and b.codeClasse = c.code")
	List<ListReglement> listReglment();
	@Query(value = "SELECT new com.pfe.myschool.dto.ListReglement (a.id,a.annee,a.numero,a.dateReglement,a.matricule,a.montant,b.nom,b.prenom,c.libelle)"
			+ " from Reglement a, Etudiant b, Classe c   where a.matricule = b.matricule and b.codeClasse = c.code and annee = :annee")
	List<ListReglement> listReglmentannee(@Param("annee") int annee);

	@Query(value = "SELECT count(*) From Reglement where annee = :annee and month(dateReglement) = :m")
	public int nbre1(@Param("annee") int annee,@Param("m") int m);
	
	@Query(value = "SELECT sum(montant) From Reglement  where annee = :annee and month(dateReglement) = :m")
	public double n1(@Param("annee") int annee,@Param("m") int m);
	
	@Query(value = "SELECT count(*) From Reglement where annee = :annee")
	public int nbre2(@Param("annee") int annee);
	
	@Query(value = "SELECT sum(montant) FROM Reglement where annee = :annee ")
	public double tot1(@Param("annee") int annee);

	List<Reglement> findByDateReglementBetween(Date d1, Date d2);
	
}