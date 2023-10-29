package com.pfe.myschool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pfe.myschool.dto.StatData;
import com.pfe.myschool.model.StatReglement;

@Repository
public interface StatReglementRepository extends JpaRepository<StatReglement, Long> {

	@Query(value = "SELECT new com.pfe.myschool.dto.StatData (a.n)"
			+ " from StatReglement a")
	List<StatData> listData();

}
