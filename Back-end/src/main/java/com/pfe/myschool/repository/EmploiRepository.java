package com.pfe.myschool.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.pfe.myschool.model.Emploi;
@Repository
public interface EmploiRepository extends JpaRepository<Emploi, Long>{
	
	@Query(value = "SELECT count(numero) FROM Emploi where annee = :ann")
	public int nbre(@Param("ann") int ann);
	@Query(value = "SELECT max(numero) FROM Emploi  where annee = :ann")
	public int max(@Param("ann") int ann);

}


