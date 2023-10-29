package com.pfe.myschool.service;

import com.pfe.myschool.model.Enseignant;
import com.pfe.myschool.model.Etablissement;
import com.pfe.myschool.model.FormationProposal;
import com.pfe.myschool.repository.FormationProposalRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class formationService {

    final
    FormationProposalRepository formation ;

    public formationService(FormationProposalRepository formation) {
        this.formation = formation;
    }

    public List<FormationProposal> getAll() {
        System.out.println("Get all Formation 11111...");
        return formation.findAll();
    }
    public FormationProposal save(FormationProposal formationProposal) {

        formation.save(formationProposal).getId();
        System.out.println("Saved Formation");
        return formationProposal;
    }
    public void update(FormationProposal formationProposal) {

        formation.save(formationProposal);
    }
    public void delete(long id) {
        Optional<FormationProposal> etab = formation.findById(id);
        etab.ifPresent(formation::delete);
    }
    public List<FormationProposal> findAllByTitle(String mot) {
        return formation.findAllByTitle(mot);
    }

}
