package com.pfe.myschool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.pfe.myschool.model.Lqcm;



public interface LqcmRepository  extends JpaRepository<Lqcm, Long>{

	List<Lqcm> findByNumero(int numero);

	
}
