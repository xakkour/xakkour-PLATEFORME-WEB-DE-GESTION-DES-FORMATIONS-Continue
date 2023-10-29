package com.pfe.myschool.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.pfe.myschool.model.Etudiant;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long>{
	
	List<Etudiant> findAllByNomContaining(String nom);
	@Query(value = "SELECT count(matricule) FROM Etudiant where annee = :ann")
	public int nbre(@Param("ann") int ann);
	@Query(value = "SELECT max(matricule) FROM Etudiant  where annee = :ann")
	public int max(@Param("ann") int ann);
	
	Optional<Etudiant> findByMatricule(String mat);
	
	List<Etudiant> findAllByCodeClasse(String code);

	/*@Query(value = "SELECT new com.pfe.myschool.dto.ListEtudiant (a.id,a.mat,a.nom,a.prenom,b.libelle,a.genre,c.libelle,a.tel,a.email,a.dea)"
	+ " from Etudiant a, Classe b, Nationalite c   where a.codeClasse = b.code and a.codeNationalite  = c.code")
List<ListEtudiant> listEtudiant();*/

}
