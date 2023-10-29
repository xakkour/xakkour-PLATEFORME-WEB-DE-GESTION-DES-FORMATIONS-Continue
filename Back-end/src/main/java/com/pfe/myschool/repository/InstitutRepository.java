package com.pfe.myschool.repository;

import com.pfe.myschool.model.Classe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.pfe.myschool.model.Institut;

import java.util.List;

@Repository
public interface InstitutRepository extends JpaRepository<Institut, Long> {

	@Query(value = "SELECT count(code) FROM Institut")
	public int nbre();
	@Query(value = "SELECT max(code) FROM Institut")
	public int max();
	List<Institut> findAllByLibelleContaining(String libelle);
	@Query("SELECT c FROM Institut c WHERE c.code LIKE %:query% OR c.libelle LIKE %:query%")
	List<Institut> customSearch(@Param("query") String query);
}
