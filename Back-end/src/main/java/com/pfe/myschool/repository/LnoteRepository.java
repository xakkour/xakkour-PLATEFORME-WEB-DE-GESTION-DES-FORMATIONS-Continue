package com.pfe.myschool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pfe.myschool.model.Lnote;


public interface LnoteRepository extends JpaRepository<Lnote, Long>{

	List<Lnote> findByNumero(int numero);

}
