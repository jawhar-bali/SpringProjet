package com.example.spring.services;

import com.example.spring.entites.Contrat;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
@Component
public interface IContrat {
    List<Contrat> retrieveAllContrat();

    Contrat addContrat(Contrat c);

    Contrat updateContrat (Contrat c);

    Contrat retrieveContrat (Long idContrat);

    void removeContrat(Long idContrat);
   // public Contrat affectContratToEtudiant(Contrat ce, String nomE, String prenomE);
    public Contrat affectContratToEtudiant(Long idContrat, String nomE, String prenomE);
    float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate);
    List<Contrat> contratBetween2dates(Date startDate, Date endDate);

    Integer nbContratsValides(Date endDate, Date startDate);
   //public void retrieveAndUpdateStatusContrat();
}
