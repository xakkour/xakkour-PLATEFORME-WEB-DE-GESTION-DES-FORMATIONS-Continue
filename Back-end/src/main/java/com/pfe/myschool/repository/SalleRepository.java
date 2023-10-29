package com.pfe.myschool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pfe.myschool.model.Salle;



public interface SalleRepository extends JpaRepository<Salle, Long>{

	List<Salle> findAllByLibelleContaining(String libelle);

}
