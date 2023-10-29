package com.pfe.myschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.pfe.myschool.model.Inscription;

@Repository
public interface InscriptionRepository extends JpaRepository<Inscription, Long> {
	@Query(value = "SELECT count(numero) FROM Inscription where annee = :ann")
	public int nbre(@Param("ann") int ann);
	@Query(value = "SELECT max(numero) FROM Inscription  where annee = :ann")
	public int max(@Param("ann") int ann);
	
	 
/*	@Query(value = "SELECT new com.pfe.myschool.dto.ListInscription (a.id,a.annee,a.numero,a.dateInscription,a.matricule,b.nom,"
			+ "b.prenom,a.codeClasse,c.libelle,a.codeSpecialite,d.libelle,a.montant,a.dateVersement)"
			+ " from Inscription a, Etudiant b, Classe c, Specialite d where a.matricule = b.matricule and a.codeClasse = c.code and a.codeSpecialite = d.code")
	List<ListInscription> listInscription();
	@Query(value = "SELECT new com.pfe.myschool.dto.ListInscription (a.id,a.annee,a.numero,a.dateInscription,a.matricule,b.nom,"
			+ "b.prenom,a.codeClasse,c.libelle,a.codeSpecialite,d.libelle,a.montant,a.dateVersement)"
			+ " from Inscription a, Etudiant b, Classe c, Specialite d where a.matricule = b.matricule and a.codeClasse = c.code and a.codeSpecialite = d.code"
			+ " and a.id = :id")

	List<ListInscription> findAllInscription(@Param("id") long id);*/
} 




