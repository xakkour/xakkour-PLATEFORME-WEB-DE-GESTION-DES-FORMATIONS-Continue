package com.pfe.myschool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pfe.myschool.model.Matiere;

@Repository
public interface MatiereRepository extends JpaRepository<Matiere, Long>{

	List<Matiere> findAllByLibelleContaining(String libelle);



	

}
