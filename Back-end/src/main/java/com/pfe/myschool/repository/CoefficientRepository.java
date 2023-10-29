package com.pfe.myschool.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.pfe.myschool.model.Coefficient;
public interface CoefficientRepository extends JpaRepository<Coefficient, Long>{
	@Query(value = "SELECT count(code) FROM Coefficient")
	public int nbre();
	@Query(value = "SELECT max(code) FROM Coefficient")
	public int max();
	
	
	@Query(value = "SELECT (coef ) FROM Coefficient a where a.codeClasse = :cl and a.codeMatiere = :mat")
	public double getCoefficient(@Param("cl") String cl,@Param("mat") String mat);
	

	

}
