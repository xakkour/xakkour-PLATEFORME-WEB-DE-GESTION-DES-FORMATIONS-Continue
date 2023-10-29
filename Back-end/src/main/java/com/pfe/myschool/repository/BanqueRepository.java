package com.pfe.myschool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pfe.myschool.model.Banque;

@Repository
public interface BanqueRepository extends JpaRepository<Banque, Long> {

	List<Banque> findAllByLibelleContaining(String libelle);


}
