package com.pfe.myschool.controller;


import com.pfe.myschool.model.FormationProposal;
import com.pfe.myschool.repository.FormationProposalRepository;
import com.pfe.myschool.service.formationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class FormationProposalController {
    private formationService FormationService;
    private final FormationProposalRepository proposalRepository;


    public FormationProposalController(formationService formationService, FormationProposalRepository proposalRepository) {
        FormationService = formationService;
        this.proposalRepository = proposalRepository;
    }


    @GetMapping("/formation/pending")
    public List<FormationProposal> getPendingProposals() {
        return proposalRepository.findByApprovedFalse();
    }
    @PutMapping("/formation/reject/{id}")
    public ResponseEntity<String> rejectProposal(@PathVariable Long id) {
        Optional<FormationProposal> proposalOptional = proposalRepository.findById(id);

        if (proposalRepository.existsById(id)) {
            // Fetch the proposal by ID
            FormationProposal proposal = proposalRepository.getById(id);

            // Update the 'approved' field to true
            proposal.setApproved(false);

            proposalRepository.save(proposal);
            return ResponseEntity.ok("Formation proposal Rejected.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/formation/approve/{id}")
    public ResponseEntity<String> approveProposal(@PathVariable Long id) {
        try {
            // Check if the proposal exists
            if (proposalRepository.existsById(id)) {
                // Fetch the proposal by ID
                FormationProposal proposal = proposalRepository.getById(id);

                // Update the 'approved' field to true
                proposal.setApproved(true);


                proposalRepository.save(proposal);
                return ResponseEntity.ok("Formation proposal approved.");

            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error approving formation proposal.");
        }
    }
    @GetMapping("/formation")
    public List<FormationProposal> list() {
        System.out.println("Get all Formation...");
        return FormationService.getAll();
    }
    @PostMapping("/formation")
    public FormationProposal submitProposal(@RequestBody FormationProposal proposal) {
        return FormationService.save(proposal);
    }
    @PutMapping("/formation")
    public void update( @RequestBody FormationProposal formationProposal) {
        FormationService.update(formationProposal);

    }


    @GetMapping("/formation/search")

    public ResponseEntity<List<FormationProposal>> findAllByTitle(@RequestParam("query") String query) {
        List<FormationProposal> nomList = FormationService.findAllByTitle(query);
        return new ResponseEntity<>(nomList, HttpStatus.OK);
    }
    @DeleteMapping("/formation/{id}")
    public void delete(@PathVariable long id) {
        FormationService.delete(id);
    }
}

