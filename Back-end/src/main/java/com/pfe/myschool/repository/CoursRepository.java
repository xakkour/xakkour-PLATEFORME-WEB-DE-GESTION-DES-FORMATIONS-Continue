package com.pfe.myschool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pfe.myschool.dto.ListCours;
import com.pfe.myschool.model.Cours;

public interface
CoursRepository extends JpaRepository<Cours, Long>{
	@Query(value = "SELECT count(numero) FROM Cours where annee = :ann")
	public int nbre(@Param("ann") int ann);
	@Query(value = "SELECT max(numero) FROM Cours  where annee = :ann")
	public int max(@Param("ann") int ann);
	
	@Query(value = "SELECT new com.pfe.myschool.dto.ListCours (a.id,a.numero,a.annee,a.matriculeEnseignant,a.codeClasse,a.codeMatiere,b.nom,c.libelle,d.libelle,a.semestre)"
			+ " from Cours a, Enseignant b,Classe c, Matiere d  where a.codeClasse = c.code and a.matriculeEnseignant = b.matricule and a.codeMatiere = d.code and a.matriculeEnseignant  = :matricule")
	
	List<ListCours> listCours(@Param("matricule") String matricule);
	@Query(value = "SELECT new com.pfe.myschool.dto.ListCours (a.id,a.numero,a.annee,a.matriculeEnseignant,a.codeClasse,a.codeMatiere,b.nom,c.libelle,d.libelle,a.semestre)"
			+ " from Cours a, Enseignant b,Classe c, Matiere d  where a.codeClasse = c.code and a.matriculeEnseignant = b.matricule and a.codeMatiere = d.code")
	
	List<ListCours> listAll();
	
	@Query(value = "SELECT new com.pfe.myschool.dto.ListCours (a.id,a.numero,a.annee,a.matriculeEnseignant,a.codeClasse,a.codeMatiere,b.nom,c.libelle,d.libelle,a.semestre)"
			+ " from Cours a, Enseignant b,Classe c, Matiere d  where a.codeClasse = c.code and a.matriculeEnseignant = b.matricule and a.codeMatiere = d.code and a.matriculeEnseignant  = :code and a.codeClasse = :cl")
	
	List<ListCours> listMatiere(@Param("code") String code,@Param("cl") String cl);
}
