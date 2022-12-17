package com.example.spring.entites;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Set;
import java.util.List;
import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Component


public class Classe implements Serializable {
        private static final long serialVersionUID = 1L;
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="idClasse")
        private Long idClasse; // Clé primaire
        private String nomClasse;
        private Integer nombreEtudiants;
        @ManyToOne
        Etudiant etudiant;



    }


