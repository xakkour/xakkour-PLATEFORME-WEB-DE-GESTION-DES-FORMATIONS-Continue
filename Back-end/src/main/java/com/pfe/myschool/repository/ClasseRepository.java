package com.pfe.myschool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pfe.myschool.dto.ListClasse;
import com.pfe.myschool.model.Classe;

@Repository
public interface ClasseRepository extends JpaRepository<Classe, Long>{

	@Query(value = "SELECT count(code) FROM Classe")
	public int nbre();
	@Query(value = "SELECT max(code) FROM Classe")
	public int max();

	List<Classe> findAllByLibelleContaining(String libelle);
	@Query(value = "SELECT new com.pfe.myschool.dto.ListClasse (a.id,a.code,a.libelle,a.codeSpecialite,a.codeDomaine,a.codeCycle,b.libelle,c.libelle,d.libelle)"
			+ " from Classe a, Specialite b, Domaine c, Cycle d  where a.codeSpecialite = b.code and a.codeDomaine = c.code and a.codeCycle = d.code")
	List<ListClasse> listClasse();


}
