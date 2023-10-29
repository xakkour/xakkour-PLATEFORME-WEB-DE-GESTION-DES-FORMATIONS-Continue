package com.pfe.myschool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pfe.myschool.model.Lemploi;
import com.pfe.myschool.model.Lqcm;


public interface LemploiRepository extends JpaRepository<Lemploi, Long>{
	List<Lemploi> findByNumero(int numero);
}
