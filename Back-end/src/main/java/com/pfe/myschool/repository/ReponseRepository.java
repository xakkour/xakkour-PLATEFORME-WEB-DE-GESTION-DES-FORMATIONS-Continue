package com.pfe.myschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pfe.myschool.model.Reponse;
public interface ReponseRepository extends JpaRepository<Reponse, Long> {

	@Query(value = "SELECT count(numero) FROM Reponse where annee = :ann")
	public int nbre(@Param("ann") int ann);
	@Query(value = "SELECT max(numero) FROM Reponse  where annee = :ann")
	public int max(@Param("ann") int ann);
	public int numero(int ann);

	

}
