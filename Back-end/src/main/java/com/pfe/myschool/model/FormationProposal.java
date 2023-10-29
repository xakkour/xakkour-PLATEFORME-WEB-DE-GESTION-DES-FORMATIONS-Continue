package com.pfe.myschool.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@Table(name = "FormationProposal")
@AllArgsConstructor @NoArgsConstructor @ToString
public class FormationProposal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;
    private String objectif;
    private boolean approved=false;

}
