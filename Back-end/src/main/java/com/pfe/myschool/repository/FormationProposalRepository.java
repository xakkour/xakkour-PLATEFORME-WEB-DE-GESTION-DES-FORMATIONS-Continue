package com.pfe.myschool.repository;

import com.pfe.myschool.model.Enseignant;
import com.pfe.myschool.model.FormationProposal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FormationProposalRepository extends JpaRepository <FormationProposal, Long> {

    List<FormationProposal> findByApprovedFalse();

    @Modifying
    @Query("UPDATE FormationProposal f SET f.approved = true WHERE f.id = :id")
    void approveProposal(@Param("id") Long id);

    @Query("SELECT c FROM FormationProposal c WHERE c.title LIKE %:query% OR c.description LIKE %:query%")
    List<FormationProposal> findAllByTitle(@Param("query") String query);
    List<FormationProposal> findAllByTitleContaining(String title);
}
