package com.pfe.myschool.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pfe.myschool.model.Lreglement;

@Repository
public interface LreglementRepository extends JpaRepository<Lreglement, Long> {

	List<Lreglement> findByNumero(int numero);

	

}
